package com.renguangli.springbootmail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * MailController
 *
 * @author renguangli 2018/8/29 17:22
 * @since JDK 1.8
 */
@Controller
public class MailController {

    @Resource
    private MailService mailService;

    @GetMapping(value = {"", "/"})
    public String index() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/mails")
    public Result listMail(int page, int limit) {
        Pageable pageable = new PageRequest(page - 1, limit);
        Page<Mail> data = mailService.listMail(pageable, null);
        return new Result(data.getContent(), data.getTotalElements());
    }

    @ResponseBody
    @PostMapping("/mail/send")
    public boolean sendSimpleMail(Mail mail) {
        return mailService.sendAndSave(mail);
    }

}
