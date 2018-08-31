package com.renguangli.springbootmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * MailServiceImpl
 *
 * @author renguangli 2018/8/29 17:18
 * @since JDK 1.8
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${mail.send.retry}")
    private int RETRY = 5;

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendSimpleMail(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());
        message.setTo(mail.getTo());
        message.setSentDate(mail.getSendDate());
        long start = System.currentTimeMillis();
        long end = 0;
        try {
            javaMailSender.send(message);
            end = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
            end = System.currentTimeMillis();
            mail.setSuccess(false);
            log.info("邮件发送失败");

        }
        mail.setSendTime(end - start);
        log.info("记录邮件发送日志");
        System.out.println(mail);
    }

    /**
     * 定时重新发送失败的邮件(最多5次）
     */
    @Scheduled(fixedRate = 2000)
    public void sendMailTask() {
        System.out.println("重新发送失败邮件！");
    }

}
