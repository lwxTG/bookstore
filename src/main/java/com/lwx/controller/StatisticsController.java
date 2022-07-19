package com.lwx.controller;

import com.lwx.service.IBookService;
import com.lwx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * @author lwx
 * @create 2022/5/19-15:15
 */
@Controller
public class StatisticsController {

    @Autowired
    private IBookService bookService;
    
    @Autowired
    private IUserService userService;

    @GetMapping("/countByType")
    public String countByType(Model model) {

        List<Map<String, Object>> list = bookService.getBookCountByType();
        List<Object> counts = new ArrayList<>(list.size());
        List<Object> bookTypes = new ArrayList<>(list.size());
        for (Map<String, Object> map : list) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if ("count".equals(key)) {
                    counts.add(map.get(key));
                } else if ("type".equals(key)) {
                    bookTypes.add(map.get(key));
                }
            }
        }
        model.addAttribute("counts", counts);
        model.addAttribute("bookTypes", bookTypes);

        return "statistics/type_statistics";
    }

    @GetMapping("/bookStatistics")
    public String bookStatistics(Model model) {

        List<Map<String, Object>> list1 = bookService.getBookDonateAmount();
        List<Object> donateBookNames = new ArrayList<>(list1.size());
        List<Object> donateAmounts = new ArrayList<>(list1.size());
        for (Map<String, Object> map : list1) {
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
        Collections.reverse(donateBookNames);
        Collections.reverse(donateAmounts);
        model.addAttribute("donateBookNames", donateBookNames);
        model.addAttribute("donateAmounts", donateAmounts);


        List<Map<String, Object>> list2 = bookService.getBookPurchaseAmount();
        List<Object> purchaseBookNames = new ArrayList<>(list2.size());
        List<Object> purchaseAmounts = new ArrayList<>(list2.size());
        for (Map<String, Object> map : list2) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if ("bookName".equals(key)) {
                    purchaseBookNames.add(map.get(key));
                } else if ("purchaseAmount".equals(key)) {
                    purchaseAmounts.add(map.get(key));
                }
            }
        }
        Collections.reverse(purchaseBookNames);
        Collections.reverse(purchaseAmounts);
        model.addAttribute("purchaseBookNames", purchaseBookNames);
        model.addAttribute("purchaseAmounts", purchaseAmounts);


        List<Map<String, Object>> list3 = bookService.getBookLendTimes();
        List<Object> lendBookNames = new ArrayList<>(list3.size());
        List<Object> lendTimes = new ArrayList<>(list3.size());
        for (Map<String, Object> map : list3) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if ("bookName".equals(key)) {
                    lendBookNames.add(map.get(key));
                } else if ("lendTimes".equals(key)) {
                    lendTimes.add(map.get(key));
                }
            }
        }
        Collections.reverse(lendBookNames);
        Collections.reverse(lendTimes);
        model.addAttribute("lendBookNames", lendBookNames);
        model.addAttribute("lendTimes", lendTimes);

        return "statistics/book_statistics";
    }

    @GetMapping("/userStatistics")
    public String userStatistics(Model model) {

        List<Map<String, Object>> list1 = userService.getUserDonateAmount();
        List<Object> donateUserNames = new ArrayList<>(list1.size());
        List<Object> donateAmounts = new ArrayList<>(list1.size());
        for (Map<String, Object> map : list1) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if ("realName".equals(key)) {
                    donateUserNames.add(map.get(key));
                } else if ("donateAmount".equals(key)) {
                    donateAmounts.add(map.get(key));
                }
            }
        }
        Collections.reverse(donateUserNames);
        Collections.reverse(donateAmounts);
        model.addAttribute("donateUserNames", donateUserNames);
        model.addAttribute("donateAmounts", donateAmounts);


        List<Map<String, Object>> list2 = userService.getUserPurchaseAmount();
        List<Object> purchaseUserNames = new ArrayList<>(list2.size());
        List<Object> purchaseAmounts = new ArrayList<>(list2.size());
        for (Map<String, Object> map : list2) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if ("realName".equals(key)) {
                    purchaseUserNames.add(map.get(key));
                } else if ("purchaseAmount".equals(key)) {
                    purchaseAmounts.add(map.get(key));
                }
            }
        }
        Collections.reverse(purchaseUserNames);
        Collections.reverse(purchaseAmounts);
        model.addAttribute("purchaseUserNames", purchaseUserNames);
        model.addAttribute("purchaseAmounts", purchaseAmounts);


        List<Map<String, Object>> list3 = userService.getUserLendTimes();
        List<Object> lendUserNames = new ArrayList<>(list3.size());
        List<Object> lendTimes = new ArrayList<>(list3.size());
        for (Map<String, Object> map : list3) {
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if ("realName".equals(key)) {
                    lendUserNames.add(map.get(key));
                } else if ("lendTimes".equals(key)) {
                    lendTimes.add(map.get(key));
                }
            }
        }
        Collections.reverse(lendUserNames);
        Collections.reverse(lendTimes);
        model.addAttribute("lendUserNames", lendUserNames);
        model.addAttribute("lendTimes", lendTimes);

        return "statistics/user_statistics";
    }


}
