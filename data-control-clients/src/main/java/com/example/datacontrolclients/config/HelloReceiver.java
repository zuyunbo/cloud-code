package com.example.datacontrolclients.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloReceiver {


    @RabbitHandler
    @RabbitListener(queues = "queueName")
    public void process(String str1) {
        System.out.println(str1);
    }

}
