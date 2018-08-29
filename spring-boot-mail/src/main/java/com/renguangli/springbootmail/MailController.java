package com.renguangli.springbootmail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

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

    @GetMapping("/mail")
    public String sendSimpleMail(Mail mail) {
        mail.setSendDate(new Date());
        mailService.sendSimpleMail(mail);
        return super.toString();
    }

}
