package com.renguangli.quartz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * spring-boot-quartz
 * Created by renguangli at 2018/12/25 17:27
 *
 * @since JDK1.8
 */
@Controller
public class IndexController {

    @GetMapping(value = {"", "/", "index"})
    public String index() {
        return "index";
    }
}
