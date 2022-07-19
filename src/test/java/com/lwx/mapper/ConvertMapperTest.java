package com.lwx.mapper;

import com.lwx.entity.User;
import com.lwx.utils.ConvertMapper;
import com.lwx.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lwx
 * @create 2022/4/16-14:00
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConvertMapperTest {

    @Autowired
    private ConvertMapper convertMapper;

    @Test
    public void userToUserVo() {

        User user = User.builder()
                .id(1)
                .realName("da")
                .username("daa")
                .password("1223")
                .sex("男")
                .birthday(LocalDate.now())
                .telephone("121eeda")
                .email("da")
                .balance(100.0)
                .borrowPoint(1.0)
                .userRole(1)
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        UserVO userVO = convertMapper.userToUserVo(user);
        System.out.println(userVO);

    }

    @Test
    public void userToUserVOs() {
    }
}