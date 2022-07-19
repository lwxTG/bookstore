package com.lwx.controller;


import com.github.pagehelper.PageInfo;
import com.lwx.entity.User;
import com.lwx.service.IRechargeRecordService;
import com.lwx.utils.Constants;
import com.lwx.utils.JsonResult;
import com.lwx.vo.RechargeRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lwx
 * @since 2022-05-18
 */
@Controller
public class RechargeRecordController {

    @Autowired
    private IRechargeRecordService rechargeRecordService;

    @GetMapping("/rechargeList")
    public String rechargeList() {
        return "/user/recharge_list";
    }

    /**
     * 查询所有用户充值记录,分页
     */
    @RequestMapping("/rechargeRecordAll")
    @ResponseBody
    public JsonResult rechargeRecordAll(String username, Integer rechargeType, String rechargeTime, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {

        RechargeRecordVO info = new RechargeRecordVO();

        User user = new User();
        user.setUsername(username);
        info.setUser(user);

        info.setRechargeType(rechargeType);
        if (rechargeTime != null) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(rechargeTime, fmt);
            LocalDateTime dateTime = date.atStartOfDay();
            info.setRechargeTime(dateTime);
        }

        PageInfo<RechargeRecordVO> pageInfo = rechargeRecordService.findAllRechargeRecords(info, page, limit);
        return new JsonResult<RechargeRecordVO>(Constants.OK_CODE, Constants.OK_MSG, pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 删除用户充值记录
     */
    @RequestMapping("/deleteRechargeRecord")
    @ResponseBody
    public JsonResult deleteRechargeRecord(String ids) {
        String[] items = ids.split(",");
        List<Integer> list = Stream.of(items).map(Integer::parseInt).collect(Collectors.toList());
        rechargeRecordService.removeByIds(list);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }

}
