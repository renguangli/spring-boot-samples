package com.renguangli.springbootmail;

import com.renguangli.springbootmail.entity.Mail;
import com.renguangli.springbootmail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {

    @Resource
    private MailService mailService;

	@Test
	public void sendSimpleMailTest() {
        Mail mail = new Mail();
        mail.setTo("211887977@qq.com");
        mail.setSubject("简单邮件");
        mail.setText("这是一封简单邮件");
        mail.setSendDate(new Date());
        mailService.sendSimpleMail(mail);
	}

    @Test
    public void sendHtmlMailTest() {
        Mail mail = new Mail();
        mail.setTo("211887977@qq.com");
        mail.setSubject("html邮件");
        mail.setText("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>html邮件</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>这是一封html邮件</h2>\n" +
                "</body>\n" +
                "</html>");
        mail.setSendDate(new Date());
        mailService.sendHtmlMail(mail);
    }

    @Test
    public void sendStaticHtmlMailTest() {
        Mail mail = new Mail();
        mail.setTo("211887977@qq.com");
        mail.setSubject("html邮件");
        mail.setText("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>这是一封html邮件</h2>\n" +
                "<img src='https://renguangli.com/images/spring-boot/spring-boot-jpa.png' />\n" +
                "</body>\n" +
                "</html>");
        mail.setSendDate(new Date());
        mailService.sendHtmlMail(mail);
    }

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendHtmlTemplateMailTest() {
        Mail mail = new Mail();
        mail.setTo("211887977@qq.com");
        mail.setSubject("html模板邮件");

        //创建邮件正文
        Context context = new Context();
        context.setVariable("user", "dali");
        context.setVariable("id", "666");
        String emailContent = templateEngine.process("mailTemplate", context);
        mail.setText(emailContent);
        mail.setSendDate(new Date());
        mailService.sendHtmlMail(mail);
    }

    @Test
    public void sendAttachMailTest() {
        Mail mail = new Mail();
        mail.setTo("211887977@qq.com");
        mail.setSubject("带附件邮件");
        mail.setText("这是一封带附件的邮件");
        mail.setFile(new File("D:/a.txt"));
        mail.setSendDate(new Date());
        mailService.sendAttachMail(mail);
    }

}
