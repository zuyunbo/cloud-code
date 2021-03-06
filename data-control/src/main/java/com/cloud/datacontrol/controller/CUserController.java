package com.cloud.datacontrol.controller;


import com.cloud.datacontrol.conf.SimpleBatchHandler;
import com.cloud.datacontrol.config.RabbtiConfig;
import com.cloud.datacontrol.config.service.HelloSender;
import com.cloud.datacontrol.entity.CUser;
import com.cloud.datacontrol.entity.parm.CUserParam;
import com.cloud.datacontrol.service.CUserService;
import com.github.pagehelper.PageInfo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * ${comments}
 *
 * @author 2u c1111
 * @since 1.0 2021-01-25
 */
@RestController
@RequestMapping("/api/cUser")
public class CUserController {
    @Autowired
    private CUserService cUserService;

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private SimpleBatchHandler simpleBatchHandler;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @GetMapping("page")
    public Object page(CUserParam queryParam) {
/*
        PageInfo pageInfo = cUserService.pageQuery(queryParam);
*/
        rabbitTemplate.convertAndSend("exchangeName", "routingKey", "hello,rabbit~");
        return "ok";
    }

    @DeleteMapping(value = "/{id}")
    public Object remove(@PathVariable long id) {
        int result = cUserService.remove(id);
        return result;
    }


    @PostMapping(value = "/save")
    public Object save(@RequestBody CUser entity) {
        int result = cUserService.save(entity);
        return entity.getId();

    }

    @PutMapping(value = "/update")
    public Object update(@RequestBody CUser entity) {
        int result = cUserService.update(entity);
        return entity.getId();

    }


    @GetMapping(value = "/{id}/detail")
    public Object detail(@PathVariable long id) {
        CUser entity = cUserService.getById(id);
        return entity;
    }


}
