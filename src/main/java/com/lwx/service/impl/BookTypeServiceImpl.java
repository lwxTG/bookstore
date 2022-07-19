package com.lwx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.BookType;
import com.lwx.mapper.BookTypeMapper;
import com.lwx.service.IBookTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwx.utils.Constants;
import com.lwx.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
@Service
public class BookTypeServiceImpl extends ServiceImpl<BookTypeMapper, BookType> implements IBookTypeService {

    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public PageInfo<BookType> findAllBookType(BookType bookType, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<BookType> allBookTypeInfo = bookTypeMapper.findAllBookTypeInfo(bookType);
        return new PageInfo<BookType>(allBookTypeInfo);
    }
}
