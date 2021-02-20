package com.example.redis.demo1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnimalConfig.class);
        System.out.println("IOC容器创建完成...");
        context.close();
    }

}
