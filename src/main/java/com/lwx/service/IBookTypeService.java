package com.lwx.service;

import com.github.pagehelper.PageInfo;
import com.lwx.entity.BookType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
public interface IBookTypeService extends IService<BookType> {

    PageInfo<BookType> findAllBookType(BookType bookType, Integer page, Integer limit);
}
