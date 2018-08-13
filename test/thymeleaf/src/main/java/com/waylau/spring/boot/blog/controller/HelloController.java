package com.waylau.spring.boot.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String sayHello() {
        return "Thymeleaf Project Say: " + "Hello World!";
    }
}
