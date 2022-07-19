package com.lwx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.lwx.vo.PurchaseRecordVO;
import com.lwx.entity.Book;
import com.lwx.entity.PurchaseRecord;
import com.lwx.entity.User;
import com.lwx.service.IBookService;
import com.lwx.service.IPurchaseRecordService;
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
public class PurchaseRecordController {

    @Autowired
    private IPurchaseRecordService purchaseRecordService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @GetMapping("/purchaseList")
    public String lendRecordList() {
        return "/purchase/purchase_list";
    }

    /**
     * 查询所有购买记录,分页
     */
    @RequestMapping("/purchaseRecordAll")
    @ResponseBody
    public JsonResult purchaseRecordAll(String username, String realName, String bookName, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {

        PurchaseRecordVO info = new PurchaseRecordVO();

        Book book = new Book();
        book.setBookName(bookName);
        info.setBook(book);

        User user = new User();
        user.setUsername(username);
        user.setRealName(realName);
        info.setUser(user);

        PageInfo<PurchaseRecordVO> pageInfo = purchaseRecordService.findAllPurchaseRecords(info, page, limit);
        for (PurchaseRecordVO p : pageInfo.getList()) {
            p.getUser().setPassword(null);
        }
        return new JsonResult<PurchaseRecordVO>(Constants.OK_CODE, Constants.OK_MSG, pageInfo.getList(), pageInfo.getTotal());

    }

    /**
     * 图书购买页面跳转
     */
    @GetMapping("/bookPurchaseList")
    public String bookPurchaseList() {
        return "/purchase/purchase_add";
    }

    /**
     * 图书购买提交页面跳转
     */
    @GetMapping("/bookPurchase")
    public String bookPurchase(Integer id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "/purchase/purchase_submit";
    }

    /**
     * 图书购买提交
     */
    @PostMapping("/purchaseBookSubmit")
    @ResponseBody
    public JsonResult purchaseBookSubmit(Integer bookId, String username, String password, Integer purchaseAmount) {
        Book book = bookService.getById(bookId);
        Double price = book.getPrice();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        User user = userService.getOne(queryWrapper);
        double total = purchaseAmount * price;

        if (purchaseAmount <=0) {
            return new JsonResult(Constants.FAIL_CODE, "请输入正确的购买数量！！");
        }

        if (purchaseAmount > book.getAmount()) {
            return new JsonResult(Constants.FAIL_CODE, "图书库存数量不足，请减少购买量或者等待书屋补充库存后再行购买！！");
        }
        if (user != null) {
            Double balance = user.getBalance();
            if (balance >= total) {
                PurchaseRecord purchaseRecord = new PurchaseRecord()
                        .setBookId(bookId)
                        .setUserId(user.getId())
                        .setPurchaseAmount(purchaseAmount)
                        .setTotal(total);
                book.setAmount(book.getAmount()-purchaseAmount);
                bookService.updateById(book);
                user.setBalance(balance-total);
                userService.updateById(user);
                purchaseRecordService.save(purchaseRecord);
            } else {
                return new JsonResult(Constants.FAIL_CODE, "用户余额不足，请充值后再购买！！");
            }
        } else {
            return new JsonResult(Constants.FAIL_CODE, "输入的用户信息有误，请检查后重新输入！！");
        }
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }

    /**
     * 删除购买记录
     */
    @RequestMapping("/deletePurchaseRecord")
    @ResponseBody
    public JsonResult deletePurchaseRecord(String ids) {
        String[] items = ids.split(",");
        List<Integer> list = Stream.of(items).map(Integer::parseInt).collect(Collectors.toList());
        purchaseRecordService.removeByIds(list);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }

}
