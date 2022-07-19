package com.lwx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.Book;
import com.lwx.entity.LendRecord;
import com.lwx.entity.User;
import com.lwx.service.IBookService;
import com.lwx.service.ILendRecordService;
import com.lwx.service.IUserService;
import com.lwx.utils.Constants;
import com.lwx.utils.JsonResult;
import com.lwx.vo.LendRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
public class LendRecordController {

    @Autowired
    private ILendRecordService lendRecordService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @GetMapping("/lendList")
    public String lendRecordList() {
        return "/lend/lend_list";
    }

    /**
     * 查询所有借阅记录,分页
     */
    @RequestMapping("/lendRecordAll")
    @ResponseBody
    public JsonResult lendRecordAll(Integer backType, String username, String realName, String bookName, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {

        LendRecordVO info = new LendRecordVO();
        info.setBackType(backType);

        User user = new User();
        user.setUsername(username);
        user.setRealName(realName);
        info.setUser(user);

        Book book = new Book();
        book.setBookName(bookName);
        info.setBook(book);

        PageInfo<LendRecordVO> pageInfo = lendRecordService.findAllLendRecords(info, page, limit);
        List<LendRecordVO> list = pageInfo.getList();
        for(LendRecordVO lend : list){
            lend.getUser().setPassword(null);
        }
        return new JsonResult<LendRecordVO>(Constants.OK_CODE, Constants.OK_MSG, list, pageInfo.getTotal());
    }

    /**
     * 图书借阅页面跳转
     */
    @GetMapping("/bookLendList")
    public String bookLendList() {
        return "/lend/lend_add";
    }

    /**
     * 图书借阅提交页面跳转
     */
    @GetMapping("/bookLend")
    public String bookLend(Integer id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "/lend/lend_submit";
    }

    /**
     * 图书借阅提交
     */
    @PostMapping("/lendBookSubmit")
    @ResponseBody
    public JsonResult lendBookSubmit(Integer bookId, String username, String password,Integer amount) {
        Book book = bookService.getById(bookId);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        User user = userService.getOne(queryWrapper);
        if (amount <= 0) {
            return new JsonResult(Constants.FAIL_CODE, "图书数量不足无法借阅，可以预约该图书！！");
        }
        if (user != null) {
            Integer userRole = user.getUserRole();
            if (userRole == 0) {
                Double borrowPoint = user.getBorrowPoint();
                if (borrowPoint > 5) {
                    LendRecord lendRecord = new LendRecord()
                            .setBookId(bookId)
                            .setUserId(user.getId())
                            .setBackType(0);
                    book.setAmount(amount - 1);
                    bookService.updateById(book);
                    user.setBorrowPoint(borrowPoint - 5);
                    userService.updateById(user);
                    lendRecordService.save(lendRecord);
                } else {
                    return new JsonResult(Constants.FAIL_CODE, "用户借阅点不足，请充值后再借阅！！");
                }
            } else {
                LendRecord lendRecord = new LendRecord()
                        .setBookId(bookId)
                        .setUserId(user.getId())
                        .setBackType(0);
                book.setAmount(amount - 1);
                bookService.updateById(book);
                lendRecordService.save(lendRecord);
            }
        } else {
            return new JsonResult(Constants.FAIL_CODE, "输入的用户信息有误，请检查后重新输入！！");
        }
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }

    /**
     * 还书页面跳转
     */
    @GetMapping("/bookBack")
    public String bookBack(Integer id, Model model) {
        LendRecord lendRecord = lendRecordService.getById(id);
        User user = userService.getById(lendRecord.getUserId());
        Book book = bookService.getById(lendRecord.getBookId());
        model.addAttribute("lendRecord",lendRecord);
        model.addAttribute("user", user);
        model.addAttribute("book", book);
        return "/lend/lend_back";
    }

    /**
     * 还书提交
     */
    @PostMapping("/bookBackSubmit")
    @ResponseBody
    private JsonResult bookBackSubmit(Integer id, Integer backType) {
        LendRecord lendRecord = lendRecordService.getById(id);
        lendRecord.setBackType(backType);
        lendRecord.setBackTime(LocalDateTime.now());
        lendRecordService.updateById(lendRecord);
        Book book = bookService.getById(lendRecord.getBookId());
        if(backType == 4){
           return new JsonResult(Constants.OK_CODE,"图书丢失，请按相关规定赔付图书！");
        }else{
            book.setAmount(book.getAmount()+1);
            bookService.updateById(book);
        }
        return new JsonResult(Constants.OK_CODE, "还书成功");
    }

    /**
     * 删除借阅记录
     */
    @RequestMapping("/deleteLendRecord")
    @ResponseBody
    public JsonResult deleteLendRecord(String ids) {
        String[] items = ids.split(",");
        List<Integer> list = Stream.of(items).map(Integer::parseInt).collect(Collectors.toList());
        lendRecordService.removeByIds(list);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }
}
