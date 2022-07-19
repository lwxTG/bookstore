package com.lwx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lwx.vo.*;
import com.lwx.entity.Book;
import com.lwx.entity.OrderRecord;
import com.lwx.entity.User;
import com.lwx.service.*;
import com.lwx.utils.Constants;
import com.lwx.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lwx
 * @create 2022/4/21-15:22
 */
@Controller
public class UserPageController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IPurchaseRecordService purchaseRecordService;

    @Autowired
    private IOrderRecordService orderRecordService;

    @Autowired
    private IDonateRecordService donateRecordService;

    @Autowired
    private ILendRecordService lendRecordService;

    @Autowired
    private IRechargeRecordService rechargeRecordService;

    @GetMapping("/bookListForUser")
    public String bookListForUser() {
        return "/forUser/book_list";
    }

    @GetMapping("/borrowHistory")
    public String borrowHistory(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        List<LendRecordVO> list = lendRecordService.queryBorrowHistory(userId);
        for(LendRecordVO l : list){
            l.getUser().setPassword(null);
        }
        model.addAttribute("list", list);
        model.addAttribute("size",list.size());
        return "/forUser/borrow_history";
    }

    @GetMapping("/purchaseHistory")
    public String purchaseHistory(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        List<PurchaseRecordVO> list = purchaseRecordService.queryPurchaseHistory(userId);
        for(PurchaseRecordVO p : list){
            p.getUser().setPassword(null);
        }
        model.addAttribute("list", list);
        model.addAttribute("size",list.size());
        return "/forUser/purchase_history";
    }

    @GetMapping("/donateHistory")
    public String DonateHistory(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        List<DonateRecordVO> list = donateRecordService.findDonateRecordsByUserId(userId);
        for(DonateRecordVO d : list){
            d.getUser().setPassword(null);
        }
        model.addAttribute("list", list);
        model.addAttribute("size",list.size());
        return "/forUser/donate_history";
    }

    @GetMapping("/orderHistory")
    public String OrderHistory(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        List<OrderRecordVO> list = orderRecordService.findOrderRecordsByUserId(userId);
        for(OrderRecordVO o : list){
            o.getUser().setPassword(null);
        }
        model.addAttribute("list", list);
        model.addAttribute("size",list.size());
        return "/forUser/order_history";
    }

    /**
     * 图书预约页面跳转
     */
    @GetMapping("/bookOrder")
    public String bookLendList() {
        return "/order/order_add";
    }

    /**
     * 图书预约提交
     */
    @PostMapping("/orderBookSubmit")
    @ResponseBody
    public JsonResult orderBookSubmit(HttpServletRequest request, String isbn,String bookName){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        Book book = bookService.getOne(new QueryWrapper<Book>()
                .eq("isbn", isbn)
                .eq("book_name",bookName));
        if (book!=null){
            Integer bookId = book.getId();
            OrderRecord orderRecord = new OrderRecord()
                    .setUserId(userId)
                    .setBookId(bookId)
                    .setOrderStatus(0);
            orderRecordService.save(orderRecord);
        }else{
            return new JsonResult<OrderRecord>(Constants.FAIL_CODE,"输入的图书编号或者图书名有误，请检查后重新输入！！");
        }
        return new JsonResult<OrderRecord>(Constants.OK_CODE,Constants.OK_MSG);
    }

    @GetMapping("/rechargeHistory")
    public String rechargeHistory(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        List<RechargeRecordVO> list = rechargeRecordService.queryRechargeHistory(userId);
        for(RechargeRecordVO r : list){
            r.getUser().setPassword(null);
        }
        model.addAttribute("list", list);
        model.addAttribute("size",list.size());
        return "/forUser/recharge_history";
    }

    /**
     * 用户个人信息
     */
    @GetMapping("/userInfo")
    public String userInfo(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        model.addAttribute("user",userService.getById(id));
        return "/forUser/user_info";
    }

    /**
     * 用户个人信息
     */
    @GetMapping("/userInfoUpdate")
    public String userInfoUpdate(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        model.addAttribute("user",userService.getById(id));
        return "/forUser/user_info_update";
    }

    /**
     * 提交用户注册
     */
    @PostMapping("/updateUserInfoSubmit")
    @ResponseBody
    public JsonResult updateUserInfoSubmit(@RequestBody User user) {
        userService.updateById(user);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }




}
