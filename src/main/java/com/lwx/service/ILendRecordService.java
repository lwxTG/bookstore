package com.lwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.LendRecord;
import com.lwx.vo.LendRecordVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
public interface ILendRecordService extends IService<LendRecord> {

    PageInfo<LendRecordVO> findAllLendRecords(LendRecordVO lendRecordVO, Integer page, Integer limit);

    List<LendRecordVO> queryBorrowHistory(Integer userId);
}
