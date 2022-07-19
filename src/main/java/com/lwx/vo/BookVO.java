package com.lwx.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.lwx.entity.BookType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lwx
 * @create 2022/4/13-20:23
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BookVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * isbn
     */
    private String isbn;

    /**
     * 出版社
     */
    private String publish;

    /**
     * 图书类型id
     */
    private Integer typeId;

    /**
     * 图书介绍
     */
    private String introduction;

    /**
     * 价格
     */
    private Double price;

    /**
     * 图书数量
     */
    private Integer amount;

    /**
     * 上架时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime shelfTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private BookType bookType;
}
