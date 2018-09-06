package com.renguangli.ExceptionValidation;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/*
 *
 * Created by renguangli at 2018/9/1 13:31
 * @since JDK1.8
 */
@Validated
@RestController
public class UserController {

    @GetMapping(value = {"", "/"})
    public User test(@Valid User user, @Size(min = 12) int length) {
        return user;
    }
}
