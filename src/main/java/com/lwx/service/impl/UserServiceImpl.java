package com.lwx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.User;
import com.lwx.utils.ConvertMapper;
import com.lwx.mapper.UserMapper;
import com.lwx.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwx.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lwx
 * @since 2022-04-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ConvertMapper convertMapper;

    @Override
    public PageInfo<UserVO> findAllUser(User user, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<User> allUserInfo = userMapper.findAllUserInfo(user);
        List<UserVO> userVOS = convertMapper.userToUserVOs(allUserInfo);
        return new PageInfo<UserVO>(userVOS);
    }

    @Override
    public List<Map<String, Object>> getUserDonateAmount() {
        return userMapper.getUserDonateAmount();
    }

    @Override
    public List<Map<String, Object>> getUserPurchaseAmount() {
        return userMapper.getUserPurchaseAmount();
    }

    @Override
    public List<Map<String, Object>> getUserLendTimes() {
        return userMapper.getUserLendTimes();
    }
}
