package com.lwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.RechargeRecord;
import com.lwx.vo.RechargeRecordVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwx
 * @since 2022-05-18
 */
public interface IRechargeRecordService extends IService<RechargeRecord> {

    PageInfo<RechargeRecordVO> findAllRechargeRecords(RechargeRecordVO rechargeRecordVO, Integer page, Integer limit);

    List<RechargeRecordVO> queryRechargeHistory(Integer userId);
}
