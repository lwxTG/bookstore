package com.lwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lwx.vo.PurchaseRecordVO;
import com.lwx.entity.PurchaseRecord;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
public interface IPurchaseRecordService extends IService<PurchaseRecord> {

    PageInfo<PurchaseRecordVO> findAllPurchaseRecords(PurchaseRecordVO purchaseRecordVO, Integer page, Integer limit);

    List<PurchaseRecordVO> queryPurchaseHistory(Integer userId);
}
