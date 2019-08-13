package com.demo.controller;

import com.demo.price.pojo.Price;
import com.demo.service.priceService;
import com.demo.service.serviceImpl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/13
 * @description:
 */
@Controller
@RequestMapping("/price")
public class priceController {
    @Autowired
    private priceService priceService;

    @RequestMapping("/add")
    public String addPrice(Price price){
        priceService.addPrice(price);
        return "";
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Price> findAll(){
        return priceService.findAll();
    }

    @RequestMapping("/findPriceByConditions")
    @ResponseBody
    public List<Price> findPriceByConditions(Price price,String start,String end){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date startdate = format.parse(start);
            Date enddate  = format.parse(end);
           return priceService.findPriceByConditions(price,startdate,enddate);
        }catch (Exception e){
            return null;
        }
    }

}
