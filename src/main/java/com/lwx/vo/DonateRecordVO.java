package com.lwx.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.lwx.entity.Book;
import com.lwx.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lwx
 * @create 2022/4/20-16:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DonateRecordVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 图书id
     */
    private Integer bookId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 捐赠数量
     */
    private Integer donateAmount;

    /**
     * 用来感谢捐赠的借阅点
     */
    private Integer repayPoint;

    /**
     * 捐赠时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime donateTime;

    private Book book;

    private User user;
}
