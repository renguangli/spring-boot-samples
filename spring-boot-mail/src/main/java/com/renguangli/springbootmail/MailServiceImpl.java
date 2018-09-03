package com.renguangli.springbootmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MailServiceImpl
 *
 * @author renguangli 2018/8/29 17:18
 * @since JDK 1.8
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

    /**
     * 记录邮件发送日志的单线程的线程池
     */
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor(new MailThreadFactory());

    private final JavaMailSender javaMailSender;

    private final MailRepository mailRepository;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender, MailRepository mailRepository) {
        this.javaMailSender = javaMailSender;
        this.mailRepository = mailRepository;
    }

    @Override
    public Page<Mail> listMail(Pageable pageable, Mail mail) {
        return mailRepository.findAll(pageable);
    }

    @Override
    public Mail sendSimpleMail(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        mail.setSendDate(new Date());
        message.setFrom(from);
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());
        message.setTo(mail.getTo());
        message.setSentDate(mail.getSendDate());
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            mail.setSuccess(false);
            mail.setMessage(e.getMessage());
            log.error("邮件发送失败,{}", e.getMessage());
        }
        return mail;
    }

    @Override
    public void sendAndSave(Mail mail) {
        mail.setSendDate(new Date());
        long start = System.currentTimeMillis();
        mail = sendSimpleMail(mail);//发送邮件
        mail.setSendTime(System.currentTimeMillis() - start);
        //异步保存邮件发送日志
        Mail finalMail = mail;
        executorService.submit(() -> mailRepository.save(finalMail));
    }

}
