package com.demo.controller;

import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.service.BuyOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/13
 * @description:
 */
@Controller
@RequestMapping("/buyOrderBook")
public class BuyOrderBookController {
   @Autowired
   private BuyOrderBookService buyOrderBookService;
   @RequestMapping("/add")
   public String  addBuyOrderBook(BuyOrderBook buyOrderBook){
       buyOrderBookService.addBuyOrder(buyOrderBook);
       return "add_buyOrderBook";
   }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<BuyOrderBook> findAll(){
       return buyOrderBookService.findAll();
    }

    @RequestMapping("/update")
    public String updateOrder(BuyOrderBook buyOrderBook){
       buyOrderBookService.updateBuyOrderBook(buyOrderBook);
     return "add_buyOrderBook";
   }
   @RequestMapping("/toAdd")
    public  String toAdd(){
       return "add_buyOrderBook";
   }

   @RequestMapping("/delete")
    public String delete(Long bobId){
        buyOrderBookService.deleteBuyOrder(bobId);
        return "add_buyOrderBook";
   }

   @RequestMapping("/findMaxPrice")
   @ResponseBody
    public BuyOrderBook findMaxPrice(Long stockId){
       System.out.println(stockId);
       return buyOrderBookService.findMaxPrice(stockId);
   }

}
