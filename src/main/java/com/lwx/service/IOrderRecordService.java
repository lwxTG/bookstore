package com.lwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.OrderRecord;
import com.lwx.vo.OrderRecordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
public interface IOrderRecordService extends IService<OrderRecord> {

    PageInfo<OrderRecordVO> findAllOrderRecords(OrderRecordVO orderRecordVO, Integer page, Integer limit);

    List<OrderRecordVO> findOrderRecordsByUserId(@Param("userId") Integer userId);
}
