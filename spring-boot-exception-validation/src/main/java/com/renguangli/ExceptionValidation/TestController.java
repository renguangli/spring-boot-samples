package com.renguangli.ExceptionValidation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 *
 * Created by renguangli at 2018/9/1 13:31
 * @since JDK1.8
 */
@RestController
public class TestController {

    @ResponseBody
    @GetMapping("/{test}")
    public String test(@PathVariable String test, int age) throws Exception {
        throw new Exception("hello world");
    }
}
