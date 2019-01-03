package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * spring-boot-demo
 * Created by renguangli at 2018/10/13 18:54
 * @since JDK1.8
 */
@RestController
public class DemoController {

    @GetMapping("/")
    public String helloSpringBoot() {
        return "Hello Spring Boot";
    }

    @PostMapping("/user")
    public String post() {
        return "Hello Spring Boot";
    }
}
