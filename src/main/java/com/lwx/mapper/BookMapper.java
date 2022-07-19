package com.lwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.vo.BookVO;
import com.lwx.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwx
 * @since 2022-04-13
 */
@Mapper
@Repository
public interface BookMapper extends BaseMapper<Book> {

    List<BookVO> findAllBookInfo(BookVO bookVO);

    List<Map<String,Object>> getBookCountByType();

    List<Map<String,Object>> getBookDonateAmount();

    List<Map<String,Object>> getBookPurchaseAmount();

    List<Map<String,Object>> getBookLendTimes();
}
