package com.lwx.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author lwx
 * @create 2022/4/21-13:32
 */
@Component
public class MailUtil {

    @Value("${spring.mail.username}")
    private String MAIL_SENDER; //邮件发送者

    @Autowired
    private JavaMailSender javaMailSender;

    private Logger log = Logger.getLogger(MailUtil.class);

    /**
     * 发送文本邮件
     *
     * @param mailBean
     */
    public  void sendSimpleMail(MailBean mailBean) {
        try {
            SimpleMailMessage mailMessage= new SimpleMailMessage();
            mailMessage.setFrom(MAIL_SENDER);
            mailMessage.setTo(mailBean.getRecipient());
            mailMessage.setSubject(mailBean.getSubject());
            mailMessage.setText(mailBean.getContent());
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败",e);
        }
    }
}
