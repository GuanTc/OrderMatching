package com.demo.controller;

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
    public String addStock(Stock stock){
        stockSercive.addStock(stock);
        return "add_stock";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add_stock";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Stock> findAll(){
        return stockSercive.findAll();
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Stock> findStockByContidions(Stock stock){
        return stockSercive.findStockByConditions(stock);
    }
}
