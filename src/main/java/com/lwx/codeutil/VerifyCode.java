package com.lwx.codeutil;

import lombok.Data;

/**
 * @author lwx
 * @create 2022/4/6-20:56
 */
@Data
public class VerifyCode {
    private String code;

    private byte[] imgBytes;

    private long expireTime;
}
