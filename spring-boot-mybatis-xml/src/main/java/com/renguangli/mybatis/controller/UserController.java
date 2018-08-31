package com.renguangli.mybatis.controller;

import com.renguangli.mybatis.annotation.GetRestMapping;
import com.renguangli.mybatis.pojo.Result;
import com.renguangli.mybatis.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * UserController
 *
 * @author renguangli 2018/8/31 17:16
 * @since JDK 1.8
 */
@Controller
public class UserController {

    @GetMapping(value = {"","/","/index"})
    public String index() {
        return "index";
    }

    @GetRestMapping("/users")
    public Result listUser(User user) {
        return null;
    }
}
