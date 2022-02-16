package com.heyufei.user.service;

import com.heyufei.user.dao.UserDao;
import com.heyufei.user.pojo.User;
import entity.StatusCode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 服务层
 *
 * @author Administrator
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }


    /**
     * 条件查询+分页
     */
    public Page<User> findSearch(Map whereMap, int page, int size) {
        Specification<User> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return userDao.findAll(specification, pageRequest);
    }


    /**
     * 条件查询
     */
    public List<User> findSearch(Map whereMap) {
        Specification<User> specification = createSpecification(whereMap);
        return userDao.findAll(specification);
    }

    /**
     * 根据ID查询实体
     * @param id
     */
    public User findById(String id) {
        return userDao.findById(id).get();
    }

    /**
     * 根据email查询实体
     */
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    /**
     * 增加
     */
    public void add(User user) {
        user.setId(idWorker.nextId() + "");
        //密码加密
        String passwordKey = encoder.encode(user.getPassword());//加密后的密码
        user.setPassword(passwordKey);
        user.setRegisterDate(new Date());//注册日期
        user.setUpdateDate(new Date());//更新日期
        user.setIsVip(0);
        userDao.save(user);
    }

    /**
     * 修改
     */
    public void update(User user) {
        userDao.save(user);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    /**
     * 动态条件构建
     * @param searchMap
     * @return
     */
    private Specification<User> createSpecification(Map searchMap) {

        return new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                // ID
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                    predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 邮箱
                if (searchMap.get("email")!=null && !"".equals(searchMap.get("email"))) {
                    predicateList.add(cb.like(root.get("email").as(String.class), "%"+(String)searchMap.get("email")+"%"));
                }
                // 密码
                if (searchMap.get("password")!=null && !"".equals(searchMap.get("password"))) {
                    predicateList.add(cb.like(root.get("password").as(String.class), "%"+(String)searchMap.get("password")+"%"));
                }
                // 昵称
                if (searchMap.get("nickname")!=null && !"".equals(searchMap.get("nickname"))) {
                    predicateList.add(cb.like(root.get("nickname").as(String.class), "%"+(String)searchMap.get("nickname")+"%"));
                }
                // 头像
                if (searchMap.get("avatar")!=null && !"".equals(searchMap.get("avatar"))) {
                    predicateList.add(cb.like(root.get("avatar").as(String.class), "%"+(String)searchMap.get("avatar")+"%"));
                }

                return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

            }
        };

    }

    /**
     * 发送短信验证码
     *
     * @param email 手机号
     */
    public int sendSms(String email) {
        //1.生成6位邮箱验证码
        Random random = new Random();
        int max = 999999;//最大数
        int min = 100000;//最小数
        int code = random.nextInt(max);//随机生成
        if (code < min) {
            code = code + min;
        }
        System.out.println(email + "验证码是：" + code);
        //2.将验证码放入redis
        try {
            redisTemplate.opsForValue().set("email_code_" + email, code + "", 3, TimeUnit.MINUTES);//1分钟过期
        }catch (Exception e){
            return StatusCode.REPERROR;
        }
        //3.将验证码和手机号发动到rabbitMQ中
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("code", String.valueOf(code));
        rabbitTemplate.convertAndSend(StatusCode.Exchange,"", map);
        return StatusCode.OK;
    }

    /**
     * 注册
     *
     * @param user 用户
     * @param code 用户填写的验证码
     */
    public void add(User user, String code) {
        //判断验证码是否正确
        String sysCode = redisTemplate.opsForValue().get("email_code_" + user.getEmail());
        //提取系统正确的验证码
        if (sysCode == null) {
            throw new RuntimeException("请点击获取短信验证码");
        }
        if (!sysCode.equals(code)) {
            throw new RuntimeException("验证码输入不正确");
        }
        String passwordKey = encoder.encode(user.getPassword());//加密后的密码
        user.setId(idWorker.nextId() + "");

        user.setPassword(passwordKey);

        user.setRegisterDate(new Date());//注册日期
        user.setUpdateDate(new Date());//更新日期
        user.setIsVip(0);
        userDao.save(user);
    }


    /**
     * 根据邮箱和密码(加密后)查询用户
     */
    public User findByMobileAndPassword(String email, String password) {
        User user = userDao.findByEmail(email);
        if (user != null && encoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 根据邮箱和密码(加密后)查询用户
     */
    public User findByEmailAndPassword2(String email, String password) {
        User user = userDao.findByEmail(email);
        if (user != null && encoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
