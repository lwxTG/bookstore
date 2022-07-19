package com.lwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.entity.RechargeRecord;
import com.lwx.vo.RechargeRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwx
 * @since 2022-05-18
 */
@Mapper
@Repository
public interface RechargeRecordMapper extends BaseMapper<RechargeRecord> {

    List<RechargeRecordVO> findAllRechargeRecordsInfo(RechargeRecordVO rechargeRecordVO);

    List<RechargeRecordVO> findRechargeRecordsByUserId(@Param("userId") Integer userId);
}
