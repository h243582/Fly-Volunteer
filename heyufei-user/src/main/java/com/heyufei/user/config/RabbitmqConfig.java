package com.heyufei.user.config;


import entity.StatusCode;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;


@Component
public class RabbitmqConfig {

//    //自动创建队列、交换机、并两者绑定
//    @RabbitListener(bindings = @QueueBinding(value = @Queue(StatusCode.QUERY), exchange = @Exchange(StatusCode.Exchange) ))
//    public void process3(String message){
//    }

//    //    创建队列
//    @Bean(value = "queue")
//    public Queue Queue(){
//        Queue queue = QueueBuilder.durable(StatusCode.QUERY).build();
//        return queue;
//    }
//
//    //    创建交换机
//    @Bean(value = "exchange")
//    public Exchange Exchange(){
//        Exchange exchange = ExchangeBuilder.fanoutExchange(StatusCode.Exchange).durable(true).build();
//        return exchange;
//    }
//    //绑定
//    @Bean
//    public Binding Binding(@Qualifier("exchange") Exchange exchange, @Qualifier("queue") Queue queue){
//        return   BindingBuilder.bind(queue).to(exchange).with("").noargs();
//    }


}

