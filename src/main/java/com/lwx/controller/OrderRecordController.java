package com.lwx.controller;


import com.github.pagehelper.PageInfo;
import com.lwx.entity.Book;
import com.lwx.entity.OrderRecord;
import com.lwx.entity.User;
import com.lwx.service.IAdminService;
import com.lwx.service.IBookService;
import com.lwx.service.IOrderRecordService;
import com.lwx.service.IUserService;
import com.lwx.utils.Constants;
import com.lwx.utils.JsonResult;
import com.lwx.utils.MailBean;
import com.lwx.utils.MailUtil;
import com.lwx.vo.OrderRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwx
 * @since 2022-04-05
 */
@Controller
public class OrderRecordController {

    @Autowired
    private IOrderRecordService orderRecordService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private MailUtil mailUtil;

    @GetMapping("/orderList")
    public String orderRecordList() {
        return "/order/order_list";
    }


    /**
     * 查询所有预约记录,分页
     */
    @RequestMapping("/orderRecordAll")
    @ResponseBody
    public JsonResult orderRecordAll(Integer orderStatus, String username, String realName, String bookName, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {

        OrderRecordVO info = new OrderRecordVO();
        info.setOrderStatus(orderStatus);

        User user = new User();
        user.setUsername(username);
        user.setRealName(realName);
        info.setUser(user);

        Book book = new Book();
        book.setBookName(bookName);
        info.setBook(book);

        PageInfo<OrderRecordVO> pageInfo = orderRecordService.findAllOrderRecords(info, page, limit);
        List<OrderRecordVO> list = pageInfo.getList();
        for (OrderRecordVO lend : list) {
            lend.getUser().setPassword(null);
        }
        return new JsonResult<OrderRecordVO>(Constants.OK_CODE, Constants.OK_MSG, list, pageInfo.getTotal());
    }

    /**
     * 审批预约界面跳转
     */
    @GetMapping("/orderDeal")
    public String orderDeal(Integer id, Model model) {
        OrderRecord orderRecord = orderRecordService.getById(id);
        model.addAttribute("orderRecord", orderRecord);
        model.addAttribute("book", bookService.getById(orderRecord.getBookId()));
        model.addAttribute("admin", adminService.getById(1));
        return "/order/order_deal";
    }

    /**
     * 预约审批提交，图书入库，通知预约用户
     */
    @PostMapping("/dealOrderSubmit")
    @ResponseBody
    public JsonResult dealOrderSubmit(Integer id, Integer bookId) {
        OrderRecord orderRecord = orderRecordService.getById(id);
        Book book = bookService.getById(bookId);
        User user = userService.getById(orderRecord.getUserId());
        Integer amount = book.getAmount();
        if (amount <= 0) {
            return new JsonResult(Constants.FAIL_CODE, "当前库存数量不足,请等到图书库存数量补充后再审批该预约！！");
        } else {
            orderRecord.setOrderStatus(1);
            orderRecordService.updateById(orderRecord);
            MailBean mailBean = new MailBean();
            mailBean.setRecipient(user.getEmail());
            mailBean.setSubject("您的图书预约已经处理");
            mailBean.setContent("您预约的图书《"+book.getBookName()+"》目前库存"+amount+"本，" + "欢迎下次来书屋选购该图书！！！");
            mailUtil.sendSimpleMail(mailBean);
            return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
        }
    }

    /**
     * 删除预约记录
     */
    @RequestMapping("/deleteOrderRecord")
    @ResponseBody
    public JsonResult deleteOrderRecord(String ids) {
        String[] items = ids.split(",");
        List<Integer> list = Stream.of(items).map(Integer::parseInt).collect(Collectors.toList());
        orderRecordService.removeByIds(list);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }
}
