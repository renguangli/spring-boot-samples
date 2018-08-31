package com.renguangli.springbootmail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MailService mailService;

	@Test
	public void contextLoads() {
        Mail mail = new Mail();
        mail.setTo("211887977@qq.com", "renguangli@bonc.com.cn");
        mail.setSubject("test");
        mail.setText("test");
        mail.setSendDate(new Date());

        log.info("保存邮件发送记录");
	}

}
