package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        ServletInitializer servletInitializer = new ServletInitializer();
        servletInitializer.init();
        System.out.println("启动成功！");
    }

}
