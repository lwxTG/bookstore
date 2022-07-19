package com.lwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.PutRecord;
import com.lwx.mapper.PutRecordMapper;
import com.lwx.service.IPutRecordService;
import com.lwx.vo.PutRecordVO;
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
public class PutRecordServiceImpl extends ServiceImpl<PutRecordMapper, PutRecord> implements IPutRecordService {

    @Autowired
    private PutRecordMapper putRecordMapper;

    @Override
    public PageInfo<PutRecordVO> findAllPutRecords(PutRecordVO putRecordVO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<PutRecordVO> list = putRecordMapper.findAllPutRecordsInfo(putRecordVO);
        PageInfo<PutRecordVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
