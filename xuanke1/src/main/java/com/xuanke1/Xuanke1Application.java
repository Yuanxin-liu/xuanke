package com.xuanke1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xuanke1.dao")
@SpringBootApplication
public class Xuanke1Application {

    public static void main(String[] args) {
        SpringApplication.run(Xuanke1Application.class, args);
    }

}
