package com.demo.controller;

import com.demo.common.ResultMap;
import com.demo.service.StockSercive;
import com.demo.stock.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockSercive stockSercive;

    @RequestMapping("/add")
    @ResponseBody
    public ResultMap addStock(Stock stock){
      ResultMap map = new ResultMap();
        try {
            stockSercive.addStock(stock);
            map.Success();
            map.setMsg("添加成功");
        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
        }
        return map;
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add_stock";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public ResultMap findAll(){
        ResultMap map = new ResultMap();
        try {
            List<Stock> list = stockSercive.findAll();
            map.Success();
            map.setObject(list);
        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
        }
        return map;
    }

    @RequestMapping("/search")
    @ResponseBody
    public ResultMap findStockByContidions(Stock stock){
        ResultMap map = new ResultMap();
        try {
            List<Stock> list = stockSercive.findStockByConditions(stock);
            map.Success();
            map.setObject(list);
        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
        }
        return map;
    }
}