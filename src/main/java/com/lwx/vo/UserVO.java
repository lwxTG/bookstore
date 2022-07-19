package com.lwx.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lwx
 * @create 2022/4/15-16:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 账号
     */
    private String username;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private LocalDate birthday;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 余额
     */
    private Double balance;

    /**
     * 借阅点数
     */
    private Integer borrowPoint;

    /**
     * 用户类型（0：普通学生 1：贫困生）
     */
    private Integer userRole;

    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime registerTime;

    /**
     * 用户信息更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
