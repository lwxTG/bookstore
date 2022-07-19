package com.lwx.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author lwx
 * @create 2022/4/6-15:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private List<T> data;
    private Long count;

    public JsonResult(Integer code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
