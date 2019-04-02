package com.renguangli.shiro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/*
 *
 * Created by renguangli at 2018/10/13 19:35
 * @since JDK1.8
 */
@Controller
public class ShiroController {

    @GetMapping(value = {"", "/", "index"})
    public String index(HttpSession session) {
        session.setAttribute("login_user", "admin");
        return "index";
    }

    @ResponseBody
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
