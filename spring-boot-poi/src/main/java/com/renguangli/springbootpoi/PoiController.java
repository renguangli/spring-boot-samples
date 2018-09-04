package com.renguangli.springbootpoi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/*
 *
 * Created by renguangli at 2018/8/25 12:18
 * @since JDK1.8
 */
@Controller
public class PoiController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String mapping = "天:tian,下:xia,无:wu,敌:di";
        List<Map<String, Object>> maps = PoiUtils.readExcel(file, mapping);
        assert maps != null;
        maps.forEach((map) -> {
            map.forEach((key, value) -> {
                System.out.println(key + "=" + value);
            });
        });
        return "redirect:/";
    }
}
