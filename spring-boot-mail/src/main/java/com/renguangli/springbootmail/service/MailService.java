package com.renguangli.springbootmail.service;

import com.renguangli.springbootmail.entity.Mail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * MailService
 *
 * @author renguangli 2018/8/29 17:16
 * @since JDK 1.8
 */
public interface MailService {

    Mail sendSimpleMail(Mail mail);

    Mail sendHtmlMail(Mail mail);

    Mail sendAttachMail(Mail mail);

    Page<Mail> listMail(Pageable pageable, Mail mail);

    void sendAndSave(Mail mail) throws Exception;

    void deleteByIdIn(Integer[] ids);

}
