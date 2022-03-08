package com.heyufei.demo.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="itcast" )
public class RabbitConfig {
    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itcast接收到消息："+message);
    }
}
