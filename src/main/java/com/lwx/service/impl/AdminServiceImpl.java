package com.lwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lwx.entity.Admin;
import com.lwx.mapper.AdminMapper;
import com.lwx.service.IAdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lwx
 * @since 2022-04-07
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
