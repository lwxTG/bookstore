package com.lwx.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @create 2022/4/19-13:49
 */
/**
 * @author lwx
 * @create 2022/4/19-13:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LendRecordVO implements Serializable {

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
     * 借阅时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime lendTime;

    /**
     * 还书时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime backTime;

    /**
     * 还书类型（0：正常还书、1：破损还书、2：图书丢失、3：延迟还书）
     */
    private Integer backType;

    private Book book;

    private User user;
}