package com.lwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.entity.LendRecord;
import com.lwx.vo.LendRecordVO;
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
public interface LendRecordMapper extends BaseMapper<LendRecord> {

    List<LendRecordVO> findAllLendRecordsInfo(LendRecordVO lendRecordVO);

    List<LendRecordVO> findLendRecordsByUserId(@Param("userId") Integer userId);
}
