package com.lwx.utils;

import com.lwx.entity.User;
import com.lwx.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author lwx
 * @create 2022/4/15-16:26
 */
@Mapper(componentModel = "spring")
public interface ConvertMapper {

    ConvertMapper INSTANCE = Mappers.getMapper(ConvertMapper.class);

    UserVO userToUserVo(User user);

    List<UserVO> userToUserVOs(List<User> users);


}
