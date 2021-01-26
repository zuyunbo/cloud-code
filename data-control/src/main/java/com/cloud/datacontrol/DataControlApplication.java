package com.cloud.datacontrol;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cloud.datacontrol.mapper")
@SpringBootApplication
public class DataControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataControlApplication.class, args);
    }

}
