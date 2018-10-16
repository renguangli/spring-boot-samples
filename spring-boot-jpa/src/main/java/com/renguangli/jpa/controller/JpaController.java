package com.renguangli.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *
 * Created by renguangli at 2018/10/15 19:47
 * @since JDK1.8
 */
@Controller
public class JpaController {

    @GetMapping("/pageView/user")
    public String user() {
        return "user";
    }

    @GetMapping(value = {"", "/", "/index"})
    public String index() {
        return "index";
    }
}
