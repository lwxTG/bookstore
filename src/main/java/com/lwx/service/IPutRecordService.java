package com.lwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.PutRecord;
import com.lwx.vo.PutRecordVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwx
 * @since 2022-05-18
 */
public interface IPutRecordService extends IService<PutRecord> {

    PageInfo<PutRecordVO> findAllPutRecords(PutRecordVO putRecordVO, Integer page, Integer limit);
}
