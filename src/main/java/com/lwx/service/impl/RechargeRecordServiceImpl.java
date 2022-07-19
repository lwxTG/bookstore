package com.lwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.RechargeRecord;
import com.lwx.mapper.RechargeRecordMapper;
import com.lwx.service.IRechargeRecordService;
import com.lwx.vo.RechargeRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwx
 * @since 2022-05-18
 */
@Service
public class RechargeRecordServiceImpl extends ServiceImpl<RechargeRecordMapper, RechargeRecord> implements IRechargeRecordService {

    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    @Override
    public PageInfo<RechargeRecordVO> findAllRechargeRecords(RechargeRecordVO rechargeRecordVO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<RechargeRecordVO> list = rechargeRecordMapper.findAllRechargeRecordsInfo(rechargeRecordVO);
        PageInfo<RechargeRecordVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<RechargeRecordVO> queryRechargeHistory(Integer userId) {
        List<RechargeRecordVO> list = rechargeRecordMapper.findRechargeRecordsByUserId(userId);
        return list;
    }
}
