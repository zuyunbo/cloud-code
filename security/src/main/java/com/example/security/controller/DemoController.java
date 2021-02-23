package com.example.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zuyunbo
 * @Date 2021/2/23  10:12 上午
 **/
@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String sayhello(){
        return "hello spring-security";
    }

}
