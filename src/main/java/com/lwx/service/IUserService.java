package com.lwx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.User;
import com.lwx.vo.UserVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lwx
 * @since 2022-04-08
 */
public interface IUserService extends IService<User> {

    PageInfo<UserVO> findAllUser(User user, Integer page, Integer limit);

    List<Map<String,Object>> getUserDonateAmount();

    List<Map<String,Object>> getUserPurchaseAmount();

    List<Map<String,Object>> getUserLendTimes();
}
