package com.lwx.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lwx
 * @create 2022/4/21-13:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MailBean implements Serializable {

    private static final long serialVersionUID = -2116367492649751914L;

    private String recipient;//邮件接收人

    private String subject; //邮件主题

    private String content; //邮件内容

}
