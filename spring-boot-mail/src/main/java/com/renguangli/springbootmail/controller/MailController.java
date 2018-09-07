package com.renguangli.springbootmail.controller;

import com.renguangli.springbootmail.common.Result;
import com.renguangli.springbootmail.entity.Mail;
import com.renguangli.springbootmail.service.MailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * MailController
 *
 * @author renguangli 2018/8/29 17:22
 * @since JDK 1.8
 */
@RestController
public class MailController {

    @Resource
    private MailService mailService;

    @GetMapping("/mails")
    public Result listMail(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "10") int limit) {
        Pageable pageable = new PageRequest(page - 1, limit);
        Page<Mail> data = mailService.listMail(pageable, null);
        return new Result(data.getTotalElements(), data.getContent());
    }

    @PostMapping("/mail")
    public Result sendSimpleMail(@Validated Mail mail) throws Exception {
        mailService.sendAndSave(mail);
        return new Result();
    }

    @DeleteMapping("/mails")
    public Result deleteByIdIn(@RequestParam("ids[]") Integer[] ids) {
        mailService.deleteByIdIn(ids);
        return new Result();
    }

}
