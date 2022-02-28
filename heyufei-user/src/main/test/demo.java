import com.heyufei.user.dao.UserDao;
import com.heyufei.user.pojo.User;
import com.heyufei.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import util.IdWorker;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@SpringBootTest
public class demo {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    BCryptPasswordEncoder encoder;


    @Test
    public void contextLoads() {
        BoundValueOperations<String, String> str1 = redisTemplate.boundValueOps("str");

        //添加键值
        str1.set("何昱飞飞");
        //获取键值
        String string = str1.get();
        System.out.println(string);

    }

    @Test
    public void contextLoad2() {

        redisTemplate.opsForValue().set("email_code_" + "243582@qq.com", "888446" + "", 3, TimeUnit.MINUTES);//1分钟过期


    }

    @Test
    public void contextLoad3() {
        for (int i=9101;i<9202; i++){
            User user = new User();

            user.setId(idWorker.nextId() + "");
            user.setEmail(String.valueOf(i)+"@qq.com");
            //密码加密
            String passwordKey = encoder.encode("123");//加密后的密码
            user.setPassword(passwordKey);

            user.setNickname("模拟"+String.valueOf(i));
            user.setAvatar("https:heyufei-1305336662.cos.ap-shanghai.myqcloud.com/Fly-Volunteer/Head-202202162026java2.jpg");
            user.setRegisterDate(new Date());//注册日期
            user.setUpdateDate(new Date());//更新日期
            user.setIsVip(false);
            userDao.save(user);


        }



    }
}
