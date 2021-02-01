package com.cloud.datacontrol.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbtiConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

}
