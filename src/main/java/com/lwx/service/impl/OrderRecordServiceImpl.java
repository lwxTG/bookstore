package com.lwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.OrderRecord;
import com.lwx.mapper.OrderRecordMapper;
import com.lwx.service.IOrderRecordService;
import com.lwx.vo.OrderRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
@Service
public class OrderRecordServiceImpl extends ServiceImpl<OrderRecordMapper, OrderRecord> implements IOrderRecordService {

    @Autowired
    private OrderRecordMapper orderRecordMapper;

    @Override
    public PageInfo<OrderRecordVO> findAllOrderRecords(OrderRecordVO orderRecordVO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<OrderRecordVO> list = orderRecordMapper.findAllOrderRecordsInfo(orderRecordVO);
        PageInfo<OrderRecordVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<OrderRecordVO> findOrderRecordsByUserId(Integer userId) {
        List<OrderRecordVO> list = orderRecordMapper.findOrderRecordsByUserId(userId);
        return list;
    }
}
