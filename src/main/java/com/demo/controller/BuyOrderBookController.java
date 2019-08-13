package com.demo.controller;

import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.common.ResultMap;
import com.demo.service.BuyOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
   @ResponseBody
   public ResultMap addBuyOrderBook(BuyOrderBook buyOrderBook){
       ResultMap map = new ResultMap();
       try{
           buyOrderBookService.addBuyOrder(buyOrderBook);
           map.Success();
           map.setMsg("添加成功了");

       }catch (Exception e){
           map.Error();
           map.setMsg("添加失败");

       }
      return map;
   }
    @RequestMapping("/findAll")
    @ResponseBody
    public ResultMap findAll(){
       ResultMap map = new ResultMap();
       try {
           List<BuyOrderBook> buyOrderBooks = buyOrderBookService.findAll();
           for(int i=0;i<buyOrderBooks.size();i++){
               System.out.println(buyOrderBooks.get(i));
           }
           map.Success();
           map.setObject(buyOrderBooks);
       }catch (Exception e){
           map.Error();
           map.setMsg("网络异常");
       }
       return map;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMap updateOrder(BuyOrderBook buyOrderBook){
       ResultMap map = new ResultMap();
       try {
           buyOrderBookService.updateBuyOrderBook(buyOrderBook);
           map.Success();
           map.setMsg("更新成功");
       }catch (Exception e){
           map.Error();
           map.setMsg("更新失败");
       }
     return map;
   }
   @RequestMapping("/toAdd")
    public  String toAdd(){
       return "add_buyOrderBook";
   }

   @RequestMapping("/delete")
   @ResponseBody
    public ResultMap delete(Long bobId){
        ResultMap map = new ResultMap();
       try {
           buyOrderBookService.deleteBuyOrder(bobId);
           map.Success();
           map.setMsg("删除成功");
       }catch (Exception e){
           map.Error();
           map.setMsg("删除失败");
       }
        return map;
   }

   @RequestMapping("/findMaxPrice")
   @ResponseBody
    public ResultMap findMaxPrice(Long stockId){
       ResultMap map = new ResultMap();
       try {
          BuyOrderBook buyOrderBook = buyOrderBookService.findMaxPrice(stockId);
          map.Success();
          map.setObject(buyOrderBook);
       }catch (Exception e){
           map.Error();
           map.setMsg("网络异常");
       }
       System.out.println(stockId);
       return map;
   }

}
