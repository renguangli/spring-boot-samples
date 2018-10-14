package com.renguangli.jsp;

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
public class JspController {

    @GetMapping("/user")
    public String index(Model model, HttpSession session) {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "admin", "admin", LocalDateTime.now()));
        users.add(new User(1L, "dali", "dali", LocalDateTime.now()));
        model.addAttribute("users", users);
        session.setAttribute("login_user", "admin");
        return "user";
    }
}
