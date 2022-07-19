package com.lwx.controller;


import com.github.pagehelper.PageInfo;
import com.lwx.entity.Book;
import com.lwx.service.IPutRecordService;
import com.lwx.utils.Constants;
import com.lwx.utils.JsonResult;
import com.lwx.vo.PutRecordVO;
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
public class PutRecordController {

    @Autowired
    private IPutRecordService putRecordService;

    @GetMapping("/putList")
    public String lendRecordList() {
        return "/book/put_list";
    }

    /**
     * 查询所有图书入库记录,分页
     */
    @RequestMapping("/putRecordAll")
    @ResponseBody
    public JsonResult putRecordAll(String bookName, String putTime, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {

        PutRecordVO info = new PutRecordVO();

        Book book = new Book();
        book.setBookName(bookName);
        info.setBook(book);

        if (putTime != null) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(putTime, fmt);
            LocalDateTime dateTime = date.atStartOfDay();
            info.setPutTime(dateTime);
        }

        PageInfo<PutRecordVO> pageInfo = putRecordService.findAllPutRecords(info, page, limit);
        return new JsonResult<PutRecordVO>(Constants.OK_CODE, Constants.OK_MSG, pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 删除图书入库记录
     */
    @RequestMapping("/deletePutRecord")
    @ResponseBody
    public JsonResult deletePutRecord(String ids) {
        String[] items = ids.split(",");
        List<Integer> list = Stream.of(items).map(Integer::parseInt).collect(Collectors.toList());
        putRecordService.removeByIds(list);
        return new JsonResult(Constants.OK_CODE, Constants.OK_MSG);
    }
}
