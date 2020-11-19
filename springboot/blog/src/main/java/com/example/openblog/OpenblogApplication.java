package com.example.openblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.openblog")
@SpringBootApplication
public class OpenblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenblogApplication.class, args);
    }

}
