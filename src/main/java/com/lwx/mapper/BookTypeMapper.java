package com.lwx.mapper;

import com.lwx.entity.BookType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
@Mapper
@Repository
public interface BookTypeMapper extends BaseMapper<BookType> {

    List<BookType> findAllBookTypeInfo(BookType bookType);
}
