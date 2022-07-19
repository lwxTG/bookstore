package com.lwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.vo.BookVO;
import com.lwx.entity.Book;
import com.lwx.mapper.BookMapper;
import com.lwx.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwx
 * @since 2022-04-13
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageInfo<BookVO> findAllBookAndType(BookVO bookVO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<BookVO> list = bookMapper.findAllBookInfo(bookVO);
        PageInfo<BookVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Map<String, Object>> getBookCountByType() {
        return bookMapper.getBookCountByType();
    }

    @Override
    public List<Map<String, Object>> getBookDonateAmount() {
        return bookMapper.getBookDonateAmount();
    }

    @Override
    public List<Map<String, Object>> getBookPurchaseAmount() {
        return bookMapper.getBookPurchaseAmount();
    }

    @Override
    public List<Map<String, Object>> getBookLendTimes() {
        return bookMapper.getBookLendTimes();
    }


}
