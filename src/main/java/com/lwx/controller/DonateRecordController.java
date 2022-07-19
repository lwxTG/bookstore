package com.lwx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.lwx.vo.DonateRecordVO;
import com.lwx.entity.Book;
import com.lwx.entity.DonateRecord;
import com.lwx.entity.User;
import com.lwx.service.IBookService;
import com.lwx.service.IDonateRecordService;
import com.lwx.service.IUserService;
import com.lwx.utils.Constants;
import com.lwx.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
@Controller
public class DonateRecordController {

    @Autowired
    private IDonateRecordService donateRecordService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @GetMapping("/donateList")
    public String lendRecordList() {
        return "/donate/donate_list";
    }

    /**
     * 查询所donate分页
     */
    @RequestMapping("/donateRecordAll")
    @ResponseBody
    public JsonResult donateRecordAll(String username, String realName, String bookName, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {

        DonateRecordVO info = new DonateRecordVO();

        Book book = new Book();
        book.setBookName(bookName);
        info.setBook(book);

        User user = new User();
        user.setUsername(username);
        user.setRealName(realName);
        info.setUser(user);

        PageInfo<DonateRecordVO> pageInfo = donateRecordService.findAllDonateRecords(info, page, limit);
        for (DonateRecordVO d : pageInfo.getList()) {
            d.getUser().setPassword(null);
        }
        return new JsonResult<DonateRecordVO>(Constants.OK_CODE, Constants.OK_MSG, pageInfo.getList(), pageInfo.getTotal());

    }

    /**
     * 图书捐赠页面跳转
     */
    @GetMapping("/bookDonateList")
    public String bookDonateList() {
        return "/donate/donate_add";
    }

    /**
     * 图书捐赠提交页面跳转
     */
    @GetMapping("/bookDonate")
    public String bookDonate(Integer id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "/donate/donate_submit";
    }

    /**
     * 图书捐赠提交
     */
    @PostMapping("/donateBookSubmit")
    @ResponseBody
    public JsonResult donateBookSubmit(Integer bookId, String username,Integer donateAmount, Integer repayPoint) {
        Book book = bookService.getById(bookId);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userService.getOne(queryWrapper);
        if (donateAmount <=0 ){
            return new JsonResult(Constants.FAIL_CODE,"请输入正确的捐赠数量！！");
        }
        if (repayPoint <=0 ){
            return new JsonResult(Constants.FAIL_CODE,"请输入正确的返还借阅点数！！");
        }
        if (user != null) {
            DonateRecord donateRecord = new DonateRecord()
                    .setBookId(bookId)
                    .setUserId(user.getId())
                    .setDonateAmount(donateAmount)
                    .setRepayPoint(repayPoint);
            book.setAmount(book.getAmount()+donateAmount);
            bookService.updateById(book);
            user.setBorrowPoint(user.getBorrowPoint()+repayPoint);
            userService.updateById(user);
            donateRecordService.save(donateRecord);
        }else{
            return new JsonResult(Constants.FAIL_CODE,"输入的用户名不存在,请检查后重新输入");
        }
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }

    /**
     * 删除捐赠记录
     */
    @RequestMapping("/deleteDonateRecord")
    @ResponseBody
    public JsonResult deleteDonateRecord(String ids) {
        String[] items = ids.split(",");
        List<Integer> list = Stream.of(items).map(Integer::parseInt).collect(Collectors.toList());
        donateRecordService.removeByIds(list);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }
}
