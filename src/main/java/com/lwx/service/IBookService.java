package com.lwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.Book;
import com.lwx.vo.BookVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lwx
 * @since 2022-04-13
 */
public interface IBookService extends IService<Book> {

    PageInfo<BookVO> findAllBookAndType(BookVO bookVO, Integer pageNum, Integer limit);

    List<Map<String, Object>> getBookCountByType();

    List<Map<String,Object>> getBookDonateAmount();

    List<Map<String,Object>> getBookPurchaseAmount();

    List<Map<String,Object>> getBookLendTimes();
}
