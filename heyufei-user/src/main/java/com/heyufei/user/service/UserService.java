package com.heyufei.user.service;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

import com.heyufei.user.dao.UserDao;
import com.heyufei.user.pojo.User;

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
     */
    public User findById(String id) {
        return userDao.findById(id).get();
    }

    /**
     * 增加
     */
    public void add(User user) {
//        user.setId(idWorker.nextId() + "");
        //密码加密
        String passwordKey = encoder.encode(user.getPassword());//加密后的密码
        user.setPassword(passwordKey);
        user.setRegisterDate(new Date());//注册日期
        user.setUpdateDate(new Date());//更新日期
        user.setLastDate(new Date());//最后登陆日期
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
                // 手机号码
                if (searchMap.get("mobile")!=null && !"".equals(searchMap.get("mobile"))) {
                    predicateList.add(cb.like(root.get("mobile").as(String.class), "%"+(String)searchMap.get("mobile")+"%"));
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
     * @param mobile 手机号
     */
    public void sendSms(String mobile) {
        //1.生成6位短信验证码
        Random random = new Random();
        int max = 999999;//最大数
        int min = 100000;//最小数
        int code = random.nextInt(max);//随机生成
        if (code < min) {
            code = code + min;
        }
        System.out.println(mobile + "验证码是：" + code);
        //2.将验证码放入redis
        redisTemplate.opsForValue().set("smscode_" + mobile, code + "", 2, TimeUnit.MINUTES);//五分钟过期
        //3.将验证码和手机号发动到rabbitMQ中
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("code", code + "");
        rabbitTemplate.convertAndSend(StatusCode.Exchange,"",map);

    }

    /**
     * 增加
     * @param user 用户
     * @param code 用户填写的验证码
     */
    public void add(User user, String code) {
        //判断验证码是否正确
        String sysCode = redisTemplate.opsForValue().get("smscode_" + user.getMobile());
        //提取系统正确的验证码
        if (sysCode == null) {
            throw new RuntimeException("请点击获取短信验证码");
        }
        if (!sysCode.equals(code)) {
            throw new RuntimeException("验证码输入不正确");
        }
        String passwordKey = encoder.encode(user.getPassword());//加密后的密码
        user.setPassword(passwordKey);

        user.setRegisterDate(new Date());//注册日期
        user.setUpdateDate(new Date());//更新日期
        user.setLastDate(new Date());//最后登陆日期
        user.setIsVip(0);
        userDao.save(user);
    }

    /**
     * 根据手机号查询用户
     */
    public User findByMobile(String mobile){
        return userDao.findByMobile(mobile);
    }


    /**
     * 根据手机号和密码查询用户
     */
    public User findByMobileAndPassword(String mobile,String password){
        User user = userDao.findByMobile(mobile);
        if(user!=null && encoder.matches(password,user.getPassword())){
            return user;
        }else{
            return null;
        }
    }
}