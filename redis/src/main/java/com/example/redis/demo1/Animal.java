package com.example.redis.demo1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Animal implements InitializingBean, DisposableBean {


    public Animal(){
        System.out.println("执行了Animal类的无参数构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ceshi dsdsd");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行了Animal类的销毁方法。。。。。");

    }
}
