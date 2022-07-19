package com.lwx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwx
 * @since 2022-04-08
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> findAllUserInfo(User user);

    List<Map<String,Object>> getUserDonateAmount();

    List<Map<String,Object>> getUserPurchaseAmount();

    List<Map<String,Object>> getUserLendTimes();
}
