package com.lwx.service;

import com.lwx.utils.MailBean;
import com.lwx.utils.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author lwx
 * @create 2022/4/21-13:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMailApplicationTests {

    @Autowired
    private MailUtil mailUtil;

    @Test
    public void sendSimpleMail() {
        MailBean mailBean = new MailBean();
        mailBean.setRecipient("2724862926@qq.com");
        mailBean.setSubject("SpringBootMail之这是一封文本的邮件");
        mailBean.setContent("SpringBootMail发送一个简单格式的邮件，时间为：" + LocalDateTime.now());

        mailUtil.sendSimpleMail(mailBean);
    }

}
