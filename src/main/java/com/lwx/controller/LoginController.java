package com.lwx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lwx.codeutil.IVerifyCodeGen;
import com.lwx.codeutil.SimpleCharVerifyCodeGenImpl;
import com.lwx.codeutil.VerifyCode;
import com.lwx.entity.Admin;
import com.lwx.entity.User;
import com.lwx.service.IAdminService;
import com.lwx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lwx
 * @create 2022/4/7-22:42
 */

@Controller
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IUserService userService;

    /**
     * 登录页面的转发
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 获取验证码方法
     *
     * @param request
     * @param response
     */
    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            System.out.println("异常处理");
        }
    }

    /**
     * 登录验证
     */
    @RequestMapping("/loginIn")
    public String loginIn(HttpServletRequest request, Model model) {
        //获取用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("captcha");
        String type = request.getParameter("type");

        //判断验证码是否正确（验证码已经放入session）
        HttpSession session = request.getSession();
        String realCode = (String) session.getAttribute("VerifyCode");
        if (!realCode.equalsIgnoreCase(code)) {
            model.addAttribute("msg", "验证码不正确");
            return "login";
        } else {
            //验证码正确则判断用户名和密码
            if (type.equals("1")) {//管理员信息
                //用户名和密码是否正确
                QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
                adminQueryWrapper.eq("username",username);
                adminQueryWrapper.eq("password",password);
                Admin admin = adminService.getOne(adminQueryWrapper);
                if (admin == null) {//该用户不存在
                    model.addAttribute("msg", "用户名或密码错误");
                    return "login";
                }
                session.setAttribute("user", admin);
                session.setAttribute("type", "admin");
//                return "index";
            } else {//来自用户信息表
                QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
                userQueryWrapper.eq("username",username);
                userQueryWrapper.eq("password",password);
                User user = userService.getOne(userQueryWrapper);
                if (user == null) {
                    model.addAttribute("msg", "用户名或密码错误");
                    return "login";
                }
                session.setAttribute("user", user);
                session.setAttribute("type", "user");
//                return "indexForUser";
            }
                return "index";
        }
    }

    /**
//     * 退出功能
     */
    @GetMapping("loginOut")
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();//注销
        return "login";
    }
}
