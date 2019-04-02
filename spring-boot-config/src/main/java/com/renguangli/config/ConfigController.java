package com.renguangli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * Created by renguangli at 2018/10/13 19:35
 * @since JDK1.8
 */
@Controller
public class ConfigController {

    @Autowired
    private ConfigProperties configProperties;

    @GetMapping(value = {"", "/", "index"})
    public String index(Model model, HttpSession session) {
        // 网站标题
        model.addAttribute("title", "dali`s Blogs");
        // 登陆用户
        User loginUser = new User(2L, "admin", "admin", LocalDateTime.now());
        session.setAttribute("login_user", loginUser);
        model.addAttribute("count", 20);
        // 用户列表
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "admin", "admin", LocalDateTime.now()));
        users.add(new User(2L, "dali", "dali", LocalDateTime.now()));
        model.addAttribute("users", users);
        return "index";
    }
}
