package com.example.papersys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.papersys.mapper")
@SpringBootApplication
public class PapersysApplication {

    public static void main(String[] args) {
        SpringApplication.run(PapersysApplication.class, args);
    }

}
