package com.lwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.vo.DonateRecordVO;
import com.lwx.entity.DonateRecord;
import com.lwx.mapper.DonateRecordMapper;
import com.lwx.service.IDonateRecordService;
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
public class DonateRecordServiceImpl extends ServiceImpl<DonateRecordMapper, DonateRecord> implements IDonateRecordService {

    @Autowired
    private DonateRecordMapper donateRecordMapper;

    @Override
    public PageInfo<DonateRecordVO> findAllDonateRecords(DonateRecordVO donateRecordVO, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<DonateRecordVO> list = donateRecordMapper.findAllDonateRecordsInfo(donateRecordVO);
        PageInfo<DonateRecordVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<DonateRecordVO> findDonateRecordsByUserId(Integer userId) {
        List<DonateRecordVO> list = donateRecordMapper.findDonateRecordsByUserId(userId);
        return list;
    }
}
