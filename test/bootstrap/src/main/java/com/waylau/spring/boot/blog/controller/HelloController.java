package com.waylau.spring.boot.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String sayHello() {
        return "Bootstrap Project Say: " + "Hello World!";
    }
}
