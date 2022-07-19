package com.lwx.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author lwx
 * @create 2022/4/5-17:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IBookServiceTest {

    @Autowired
    private IBookService bookService;

//    @Test
//    public void test01(){
////        Book book = new Book().setBookName("史记").setAuthor("司马迁").setIsbn("1008").setPublish("中国人民出版社").
////                setBookType(2).setIntroduction("记载了上至上古传说中的黄帝时代，下至汉武帝太初四年间共3000多年的历史").setPrice(50.0).setAmount(2);
//        Book1 book = bookService.getById(9);
////        System.out.println(flag);
//        System.out.println(book);
//    }

    @Test
    public void test02() {

        List<Map<String, Object>> list = bookService.getBookCountByType();
        List<Object> counts = new ArrayList<>(list.size());
        List<Object> bookTypes = new ArrayList<>(list.size());
        for (Map<String, Object> map : list) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                System.out.println(map.get(key));
                if ("count".equals(key)) {
                    Integer count = (Integer) map.get(key);
                    counts.add(count);
                } else if ("type".equals(key)) {
                    String type = (String) map.get(key);
                    bookTypes.add(type);
                }
            }
        }
        System.out.println(list);
        System.out.println(counts);
        System.out.println(bookTypes);

    }

    @Test
    public void test03(){
        List<Map<String, Object>> list = bookService.getBookDonateAmount();
        List<Object> donateBookNames = new ArrayList<>(list.size());
        List<Object> donateAmounts = new ArrayList<>(list.size());
        for (Map<String, Object> map : list) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if ("bookName".equals(key)) {
                    donateBookNames.add(map.get(key));
                } else if ("donateAmount".equals(key)) {
                    donateAmounts.add(map.get(key));
                }
            }
        }
        System.out.println(donateAmounts);
        System.out.println(donateBookNames);
        System.out.println(list);
    }


}