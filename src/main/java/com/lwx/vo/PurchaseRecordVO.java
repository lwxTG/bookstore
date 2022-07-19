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
 * @create 2022/4/20-12:56
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PurchaseRecordVO implements Serializable {

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
     * 购买数量
     */
    private Integer purchaseAmount;

    /**
     * 支付金额
     */
    private Double total;

    /**
     * 购买时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime purchaseTime;

    private Book book;

    private User user;
}
