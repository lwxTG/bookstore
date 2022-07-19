package com.lwx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.lwx.entity.BookType;
import com.lwx.service.IBookTypeService;
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
public class BookTypeController {

    @Autowired
    private IBookTypeService bookTypeService;

    /**
     * 图书类型列表
     */
    @GetMapping("/typeList")
    public String bookTypeList() {
        return "type/type_list";
    }

    /**
     * 获取图书类型列表，只获取数据
     */
    @RequestMapping("/bookTypeData")
    @ResponseBody
    public List<BookType> bookTypeData( ) {
        List<BookType> list = bookTypeService.list(new QueryWrapper<>());
        return list;
    }

    /**
     * 获取type数据信息,分页
     */
    @RequestMapping("/bookTypeAll")
    @ResponseBody
    public JsonResult bookTypeAll(BookType bookType, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<BookType> allBookType = bookTypeService.findAllBookType(bookType, page, limit);
        return new JsonResult<BookType>(Constants.OK_CODE, Constants.OK_MSG, allBookType.getList(), allBookType.getTotal());
    }

    /**
     * 添加页面的跳转
     */
    @GetMapping("/bookTypeAdd")
    public String bookTypeAdd() {
        return "type/type_add";
    }

    /**
     * 提交图书类型添加
     */
    @PostMapping("/addBookTypeSubmit")
    @ResponseBody
    public JsonResult addBookTypeSubmit(BookType bookType) {
        bookTypeService.save(bookType);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }

    /**
     * 根据图书id跳转到修改页面
     */
    @GetMapping("/bookTypeUpdate")
    public String bookTypeUpdate(Integer id, Model model) {
        BookType bookType = bookTypeService.getById(id);
        model.addAttribute("bookType", bookType);
        return "type/type_update";
    }

    /**
     * 提交图书类型添加
     */
    @PostMapping("/updateBookTypeSubmit")
    @ResponseBody
    public JsonResult updateBookTypeSubmit(@RequestBody BookType bookType) {
        bookTypeService.updateById(bookType);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }


    /**
     * 图书种类删除
     */
    @RequestMapping("/deleteBookType")
    @ResponseBody
    public JsonResult deleteBookType(String ids) {
        String[] items = ids.split(",");
        List<Integer> list = Stream.of(items).map(Integer::parseInt).collect(Collectors.toList());
        bookTypeService.removeByIds(list);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG );
    }



}
