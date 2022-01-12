package com.heyufei.user.config;


import entity.StatusCode;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConfig {

    //自动创建队列、交换机、并两者绑定
    @RabbitListener(bindings = @QueueBinding(value = @Queue(StatusCode.QUERY), exchange = @Exchange(StatusCode.Exchange) ))
    public void process3(String message){
    }

}

