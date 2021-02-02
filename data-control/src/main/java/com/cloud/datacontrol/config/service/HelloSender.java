package com.cloud.datacontrol.config.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration

public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "hello " + new Date() + "    " + i;
        System.out.println("Sender : " + context +"    "+ i);
        this.rabbitTemplate.convertAndSend("user", context);
    }

}
