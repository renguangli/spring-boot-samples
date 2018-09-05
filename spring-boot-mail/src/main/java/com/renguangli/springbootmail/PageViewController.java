package com.renguangli.springbootmail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *
 * Created by renguangli at 2018/9/5 22:50
 * @since JDK1.8
 */
@Controller
public class PageViewController {

    @GetMapping(value = {"", "/"})
    public String index() {
        return "index";
    }
}
