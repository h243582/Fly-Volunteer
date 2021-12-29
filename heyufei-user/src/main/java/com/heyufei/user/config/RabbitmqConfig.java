package com.heyufei.user.config;


import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitmqConfig {

//    //2. 自动创建队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue111111111111"))
//    public void process2(String message){
//
//    }

    //3. 自动创建队列、交换机、并两者绑定
    @RabbitListener(bindings = @QueueBinding(value = @Queue("send_message_mq"), exchange = @Exchange("send_message_exchange") ))
    public void process3(String message){
    }


//    //    创建队列
//    @Bean(value = "queue")
//    public Queue Queue(){
//        Queue queue = QueueBuilder.durable("queue2222222222222222").build();
//        return queue;
//    }
//
//    //    创建交换机
//    @Bean(value = "exchange")
//    public Exchange Exchange(){
//        Exchange exchange = ExchangeBuilder.fanoutExchange("exchange_name33333333").durable(true).build();
//        return exchange;
//    }
//    //绑定
//    @Bean
//    public Binding Binding(@Qualifier("exchange") Exchange exchange, @Qualifier("queue") Queue queue){
//        return   BindingBuilder.bind(queue).to(exchange).with("").noargs();
//    }




}

