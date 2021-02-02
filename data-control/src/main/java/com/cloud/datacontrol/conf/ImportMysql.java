package com.cloud.datacontrol.conf;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.datacontrol.entity.CUser;
import com.cloud.datacontrol.entity.CUserCopy1;
import com.cloud.datacontrol.mapper.CUserCopy1Mapper;
import com.cloud.datacontrol.mapper.CUserMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Wrapper;
import java.util.List;

@Service
public class ImportMysql {

    @Autowired
    CUserMapper cUserMapper;

    private List<CUser> users;


    @Autowired
    private AmqpTemplate rabbitTemplate;

    private long pageNum = 1;

    private long pageSize = 5000;

    //读取数据库操作
    public synchronized boolean readCUser() {
        //总页数+总记录数
        QueryWrapper<CUser> cUserQueryWrapper = new QueryWrapper<>();
        Page<CUser> page = new Page<>(pageNum, pageSize);
        IPage<CUser> cUserIPage = cUserMapper.selectPage(page, cUserQueryWrapper);
        List<CUser> cUsers = cUserIPage.getRecords();
        if (!StringUtils.isEmpty(cUsers) && cUsers.size() != 0) {
            //给对象赋值
            pageNum++;
            this.users = cUsers;
            return true;
        }
        return false;
    }

    //写入数据库操作
    public void writ() {
        CUserCopy1 cUserCopy1 = new CUserCopy1();
        for (CUser cUser : users) {
            BeanUtils.copyProperties(cUser, cUserCopy1);
            cUser.setId(null);
            String userString = JSON.toJSONString(cUser);
            this.rabbitTemplate.convertAndSend("exchangeName", "routingKey", userString);
        }
    }
}
