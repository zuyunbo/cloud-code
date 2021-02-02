package com.example.datacontrolclients.config;


import com.alibaba.fastjson.JSONObject;
import com.cloud.datacontrol.entity.CUser;
import com.example.datacontrolclients.mapper.CUserMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloReceiver2 {

    @Autowired
    CUserMapper cUserMapper;

    @RabbitHandler
    @RabbitListener(queues = "queueName")
    public void process(String str1) {
        CUser user = JSONObject.parseObject(str1, CUser.class);
        cUserMapper.insert(user);


    }

}
