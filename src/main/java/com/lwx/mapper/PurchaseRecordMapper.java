package com.lwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.vo.PurchaseRecordVO;
import com.lwx.entity.PurchaseRecord;
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
public interface PurchaseRecordMapper extends BaseMapper<PurchaseRecord> {

    List<PurchaseRecordVO> findAllPurchaseRecordsInfo(PurchaseRecordVO purchaseRecordVO);

    List<PurchaseRecordVO> findPurchaseRecordsByUserId(@Param("userId") Integer userId);
}
