package com.sms.listener;

import entity.StatusCode;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 短信监听类
 */
@Component
@RabbitListener(queues = StatusCode.QUERY)
public class SmsListener {
    @Autowired
    JavaMailSenderImpl mailSender;

//     @Autowired
//     private SmsUtil smsUtil;

//     @Value("${aliyun.sms.template_code}")
//     private String template_code;//模板编号
//
//     @Value("${aliyun.sms.sign_name}")
//     private String sign_name;//签名

    @RabbitHandler
     public void sendSms(Map<String,String> map){
//        System.out.println("------heyufei-sms接收到消息, 邮箱是："+map.get("email"));
        System.out.println("------进入heyufei-sms");
        System.out.println("------heyufei-sms接收到消息, 手机号："+map.get("email"));
         System.out.println("------heyufei-sms接收到消息, 验证码："+map.get("code"));
        // try {
        //     smsUtil.sendSms(map.get("mobile"),template_code,sign_name,"{\"number\":\""+ map.get("code") +"\"}");
        // } catch (ClientException e) {
        //     e.printStackTrace();
        // }

        //
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("飞翔的志愿");
        message.setText("您的验证码是： " + map.get("code"));

        message.setTo("2435823336@qq.com");
        message.setFrom("2435823336@qq.com");
//        message.setFrom(map.get("email"));
        mailSender.send(message);

    }

}
