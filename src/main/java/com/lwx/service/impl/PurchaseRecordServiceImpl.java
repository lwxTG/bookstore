package com.lwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.vo.PurchaseRecordVO;
import com.lwx.entity.PurchaseRecord;
import com.lwx.mapper.PurchaseRecordMapper;
import com.lwx.service.IPurchaseRecordService;
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
public class PurchaseRecordServiceImpl extends ServiceImpl<PurchaseRecordMapper, PurchaseRecord> implements IPurchaseRecordService {

    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    @Override
    public PageInfo<PurchaseRecordVO> findAllPurchaseRecords(PurchaseRecordVO purchaseRecordVO, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<PurchaseRecordVO> list = purchaseRecordMapper.findAllPurchaseRecordsInfo(purchaseRecordVO);
        PageInfo<PurchaseRecordVO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<PurchaseRecordVO> queryPurchaseHistory(Integer userId) {
        List<PurchaseRecordVO> list = purchaseRecordMapper.findPurchaseRecordsByUserId(userId);
        return list;
    }
}
