package com.suixin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.suixin")
@SpringBootApplication
public class ImServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImServiceApplication.class, args);
    }

}
