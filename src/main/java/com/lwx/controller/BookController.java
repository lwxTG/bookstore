package com.lwx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.PutRecord;
import com.lwx.service.IPutRecordService;
import com.lwx.vo.BookVO;
import com.lwx.entity.Admin;
import com.lwx.entity.Book;
import com.lwx.service.IAdminService;
import com.lwx.service.IBookService;
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
 * @since 2022-04-13
 */
@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IPutRecordService putRecordService;

    /**
     * 图书列表
     */
    @GetMapping("/bookList")
    public String bookList(Model model) {
        return "/book/book_list";
    }

    /**
     * 获取book信息
     */
    @RequestMapping("/bookAll")
    @ResponseBody
    public JsonResult bookAll(BookVO bookVO, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<BookVO> allBookAndType = bookService.findAllBookAndType(bookVO, page, limit);
        return new JsonResult<BookVO>(Constants.OK_CODE, Constants.OK_MSG, allBookAndType.getList(), allBookAndType.getTotal());
    }

    /**
     * 图书添加页面的跳转
     */
    @GetMapping("/bookAdd")
    public String bookAdd() {
        return "/book/book_add";
    }

    /**
     * 图书添加提交
     */
    @RequestMapping("/addBookSubmit")
    @ResponseBody
    public JsonResult addBookSubmit(Book book) {
        book.setAmount(0);
        String isbn = book.getIsbn();
        Book book1 = bookService.getOne(new QueryWrapper<Book>().eq("isbn", isbn));
        if (book1 != null) {
            return new JsonResult(Constants.FAIL_CODE, "输入的isbn号有误,请检查后重新输入");
        } else {
            bookService.save(book);
            return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
        }
    }

    /**
     * 根据图书id修改
     */
    @GetMapping("/bookUpdate")
    public String bookUpdate(Integer id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book/book_update";
    }

    /**
     * 图书修改提交
     */
    @RequestMapping("/updateBookSubmit")
    @ResponseBody
    public JsonResult updateBookSubmit(@RequestBody Book book) {
        bookService.updateById(book);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }


    /**
     * 根据图书id入库,添加图书数量
     */
    @GetMapping("/bookPutIn")
    public String bookPutIn(Integer id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        model.addAttribute("admin", adminService.getById(1));
        return "book/book_put_in";
    }

    /**
     * 图书入库提交
     */
    @PostMapping("/putInBookSubmit")
    @ResponseBody
    public JsonResult putInBookSubmit(Integer id, Integer putNum, Double costPrice) {
        Book book = bookService.getById(id);
        Admin admin = adminService.getById(1);
        double rest = admin.getBalance() - costPrice * putNum;
        if (putNum <= 0 || costPrice <= 0) {
            return new JsonResult(Constants.FAIL_CODE,"请输入正确的入库数量或图书入库单价！！");
        }
        if (rest < 0) {
            return new JsonResult(Constants.FAIL_CODE, "当前管理员账户余额不足,请及时向上级领导反映！！");
        } else {
            book.setAmount(book.getAmount() + putNum);
            bookService.updateById(book);
            admin.setBalance(rest);
            adminService.updateById(admin);
            PutRecord putRecord = new PutRecord().setBookId(id).setPutAmount(putNum).setTotal(putNum * costPrice);
            putRecordService.save(putRecord);
            return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
        }
    }

    /**
     * 图书删除
     */
    @RequestMapping("/deleteBook")
    @ResponseBody
    public JsonResult deleteBook(String ids) {
        String[] items = ids.split(",");
        List<Integer> list = Stream.of(items).map(Integer::parseInt).collect(Collectors.toList());
        bookService.removeByIds(list);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }

}
