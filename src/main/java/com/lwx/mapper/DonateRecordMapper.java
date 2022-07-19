package com.lwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.vo.DonateRecordVO;
import com.lwx.entity.DonateRecord;
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
 * @since 2022-04-05
 */
@Mapper
@Repository
public interface DonateRecordMapper extends BaseMapper<DonateRecord> {

    List<DonateRecordVO> findAllDonateRecordsInfo(DonateRecordVO donateRecordVO);

    List<DonateRecordVO> findDonateRecordsByUserId(@Param("userId") Integer userId);
}
