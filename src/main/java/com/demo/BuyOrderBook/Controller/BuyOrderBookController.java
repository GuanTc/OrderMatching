package com.demo.BuyOrderBook.Controller;

import com.demo.BuyOrderBook.pojo.BuyOrderBook;

import com.demo.BuyOrderBook.service.BuyOrderBookService;
import com.demo.BuyOrderBook.service.ServiceImpl.BuyOrderBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *@author: WANGSHUAIYI
 *@date : 2019/8/10
 *@description:
 */
@RequestMapping("/BuyOrderBook")
@Controller
public class BuyOrderBookController {

    @Autowired
    private BuyOrderBookService buyOrderBookService;

    @RequestMapping("/add")
    public String AddBuyOrderBook(HttpSession session, Model model, BuyOrderBook buyOrderBook){
        System.out.println(buyOrderBook);
        buyOrderBookService.addBuyOrderBookService(buyOrderBook);
        return "add";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(required = true)Long id){
        buyOrderBookService.deleteBuyOrderBookById(id);
        return "add";
    }

    @RequestMapping("findFirst")
    @ResponseBody
    public BuyOrderBook findFirst(){
        return buyOrderBookService.findTheFirstBuyOrderBook();
    }
}
