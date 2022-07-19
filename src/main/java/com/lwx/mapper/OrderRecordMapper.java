package com.lwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.entity.OrderRecord;
import com.lwx.vo.OrderRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface OrderRecordMapper extends BaseMapper<OrderRecord> {

    List<OrderRecordVO> findAllOrderRecordsInfo(OrderRecordVO orderRecordVO);

    List<OrderRecordVO> findOrderRecordsByUserId(@Param("userId") Integer userId);
}
