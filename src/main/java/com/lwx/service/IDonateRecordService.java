package com.lwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lwx.vo.DonateRecordVO;
import com.lwx.entity.DonateRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
public interface IDonateRecordService extends IService<DonateRecord> {

    PageInfo<DonateRecordVO> findAllDonateRecords(DonateRecordVO donateRecordVO, Integer page, Integer limit);

    List<DonateRecordVO> findDonateRecordsByUserId(@Param("userId") Integer userId);
}
