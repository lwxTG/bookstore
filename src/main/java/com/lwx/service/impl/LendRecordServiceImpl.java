package com.lwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.LendRecord;
import com.lwx.mapper.LendRecordMapper;
import com.lwx.service.ILendRecordService;
import com.lwx.vo.LendRecordVO;
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
public class LendRecordServiceImpl extends ServiceImpl<LendRecordMapper, LendRecord> implements ILendRecordService {

    @Autowired
    private LendRecordMapper lendRecordMapper;

    @Override
    public PageInfo<LendRecordVO> findAllLendRecords(LendRecordVO lendRecordVO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<LendRecordVO> list = lendRecordMapper.findAllLendRecordsInfo(lendRecordVO);
        PageInfo<LendRecordVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<LendRecordVO> queryBorrowHistory(Integer userId) {
        List<LendRecordVO> list = lendRecordMapper.findLendRecordsByUserId(userId);
        return list;
    }
}
