package com.example.redis.demo1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.redis.demo1")
public class AnimalConfig {
    @Bean
    public Animal animal(){
        return new Animal();
    }
}
