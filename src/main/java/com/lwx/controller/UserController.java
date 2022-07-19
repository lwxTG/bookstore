package com.lwx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwx.entity.Admin;
import com.lwx.entity.RechargeRecord;
import com.lwx.entity.User;
import com.lwx.service.IAdminService;
import com.lwx.service.IRechargeRecordService;
import com.lwx.service.IUserService;
import com.lwx.utils.Constants;
import com.lwx.utils.ConvertMapper;
import com.lwx.utils.JsonResult;
import com.lwx.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lwx
 * @since 2022-04-08
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ConvertMapper convertMapper;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IRechargeRecordService rechargeRecordService;

    /**
     * 跳转到用户列表
     */
    @GetMapping("/userList")
    public String bookTypeList() {
        return "user/user_list";
    }

//    /**
//     * 获取获取数据信息,分页
//     */
//    @RequestMapping("/userAll")
//    @ResponseBody
//    public JsonResult userAll(User user, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit) {
//        PageInfo<UserVO> allUser = userService.findAllUser(user, pageNum, limit);
//        return new JsonResult<UserVO>(Constants.OK_CODE, Constants.OK_MSG, allUser.getList(), allUser.getTotal());
//    }

    /**
     * 获取获取数据信息,分页
     */
    @RequestMapping("/userAll")
    @ResponseBody
    public JsonResult userAll(User user, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        Page<User> userPage = new Page<>(page, limit);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String username = user.getUsername();
        String realName = user.getRealName();
        String telephone = user.getTelephone();
        Integer userRole = user.getUserRole();
        if (username != null) {
            queryWrapper.like("username", username);
        }
        if (realName != null) {
            queryWrapper.like("real_name", realName);
        }
        if (telephone != null) {
            queryWrapper.like("telephone", telephone);
        }
        if (userRole != null) {
            queryWrapper.like("user_role", userRole);
        }
        IPage<User> iPage = userService.page(userPage, queryWrapper);
        List<User> records = iPage.getRecords();
        List<UserVO> userVOS = convertMapper.userToUserVOs(records);
        return new JsonResult<UserVO>(Constants.OK_CODE, Constants.OK_MSG, userVOS, iPage.getTotal());
    }

    /**
     * 用户注册页面跳转
     */
    @GetMapping("/userRegister")
    public String userRegister() {
        return "user/user_register";
    }

    /**
     * 提交用户注册
     */
    @PostMapping("/userRegisterSubmit")
    @ResponseBody
    public JsonResult userRegisterSubmit(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        String username = user.getUsername();
        queryWrapper.eq("username", username);
        List<User> list = userService.list(queryWrapper);
        if (list != null && list.size() > 0) {
            String msg = "用户名 " + username + " 已被占用，请重新输入！！！";
            return new JsonResult(Constants.FAIL_CODE, msg);
        } else {
            user.setPassword("12345");
            userService.save(user);
            return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
        }
    }

    /**
     * 根据id跳转到用户信息修改页面
     */
    @GetMapping("/userUpdate")
    public String userUpdate(Integer id, Model model) {
        User user = userService.getById(id);
        UserVO userVO = convertMapper.userToUserVo(user);
        model.addAttribute("user", userVO);
        return "user/user_update";
    }

    /**
     * 提交用户信息修改
     */
    @PostMapping("/updateUserSubmit")
    @ResponseBody
    public JsonResult updateUserSubmit(@RequestBody User user) {
        userService.updateById(user);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }

    /**
     * 根据id跳转到用户充值页面
     */
    @GetMapping("/userRecharge")
    public String userRecharge(Integer id, Model model) {
        User user = userService.getById(id);
        UserVO userVO = convertMapper.userToUserVo(user);
        model.addAttribute("user", userVO);
        return "user/user_recharge";
    }

    /**
     * 根据id跳转到用户充值页面
     */
    @PostMapping("/userRechargeSubmit")
    @ResponseBody
    public JsonResult userRechargeSubmit(Integer id, Integer rechargeType, Double rechargeAmount) {
        User user = userService.getById(id);
        Admin admin = adminService.getById(1);
        if (rechargeAmount <=0){
            return new JsonResult(Constants.FAIL_CODE,"请输入正确的充值金额");
        }
        if (rechargeType == 0) {
            user.setBalance(user.getBalance() + rechargeAmount);
        } else if (rechargeType == 1) {
            if (user.getUserRole()==0){
                user.setBorrowPoint(user.getBorrowPoint() + rechargeAmount);
            }else{
                return new JsonResult(Constants.FAIL_CODE,"贫困生用户可免费借阅，无需充值借阅点");
            }
        }
        admin.setBalance(admin.getBalance() + rechargeAmount);
        adminService.updateById(admin);
        userService.updateById(user);
        RechargeRecord rechargeRecord = new RechargeRecord().setUserId(id).setRechargeType(rechargeType).setRechargeAmount(rechargeAmount);
        rechargeRecordService.save(rechargeRecord);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }

    /**
     * 根据id跳转到用户信息修改页面
     */
    @GetMapping("/userUpdatePassword")
    public String userUpdatePassword() {
        return "user/user_update_password";
    }

    /**
     * 根据id跳转到用户密码修改页面
     */
    @PostMapping("/userUpdatePasswordSubmit")
    @ResponseBody
    public JsonResult userUpdatePasswordSubmit(HttpServletRequest request, String oldPassword, String newPassword) {
        HttpSession session = request.getSession();
        Object type = session.getAttribute("type");
        if (type == "admin") {
            Admin admin = (Admin) session.getAttribute("user");
            if (oldPassword.equals(admin.getPassword())) {
                admin.setPassword(newPassword);
                adminService.updateById(admin);
            } else {
                return new JsonResult(Constants.FAIL_CODE, "输入的旧密码有误，请重新输入！");
            }

        } else {
            User user = (User) session.getAttribute("user");
            if (oldPassword.equals(user.getPassword())) {
                user.setPassword(newPassword);
                userService.updateById(user);

            } else {
                return new JsonResult(Constants.FAIL_CODE, "输入的旧密码有误，请重新输入！");
            }
        }
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }


    /**
     * 删除用户信息
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public JsonResult deleteUser(String ids) {
        String[] items = ids.split(",");
        List<Integer> list = Stream.of(items).map(Integer::parseInt).collect(Collectors.toList());
        userService.removeByIds(list);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }
}
