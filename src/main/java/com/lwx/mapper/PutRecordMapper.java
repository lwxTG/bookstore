package com.lwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.entity.PutRecord;
import com.lwx.vo.PutRecordVO;
import org.apache.ibatis.annotations.Mapper;
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
public interface PutRecordMapper extends BaseMapper<PutRecord> {

    List<PutRecordVO> findAllPutRecordsInfo(PutRecordVO putRecordVO);
}
