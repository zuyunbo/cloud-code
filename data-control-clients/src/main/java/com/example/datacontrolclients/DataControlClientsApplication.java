package com.example.datacontrolclients;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.datacontrolclients.mapper")
@SpringBootApplication
public class DataControlClientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataControlClientsApplication.class, args);
    }

}
