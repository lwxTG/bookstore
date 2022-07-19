package com.lwx.mapper;

import com.lwx.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.entity.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwx
 * @since 2022-04-07
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

}
