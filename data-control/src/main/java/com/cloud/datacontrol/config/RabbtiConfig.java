package com.cloud.datacontrol.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbtiConfig {

    @Bean
    public Queue testQueue() {
        return new Queue("queueName");
    }

    // 创建一个交换机
    @Bean
    public DirectExchange testExchange() {
        return new DirectExchange("exchangeName");
    }

    // 把队列和交换机绑定在一起
    @Bean
    public Binding testBinding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routingKey");
    }

}
