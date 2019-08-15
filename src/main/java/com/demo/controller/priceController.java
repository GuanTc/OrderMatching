package com.demo.controller;

import com.demo.common.ResultMap;
import com.demo.price.pojo.Price;
import com.demo.service.priceService;
import com.demo.service.serviceImpl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @ResponseBody
    public ResultMap addPrice(@RequestBody  Price price){
        ResultMap map = new ResultMap();
       try{
           priceService.addPrice(price);
           map.Success();
           map.setMsg("添加成功");
       }catch (Exception e){
           map.Error();
           map.setMsg("网络异常");
       }
        return map;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public ResultMap findAll(){
        ResultMap map = new ResultMap();
        try {
            List<Price> list = priceService.findAll();
            map.Success();
            map.setData(list);
        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
        }
        return map;
    }

    @RequestMapping("/findPriceByConditions")
    @ResponseBody
    public ResultMap findPriceByConditions(@RequestBody Price price,@RequestBody String start,@RequestBody String end){
        ResultMap map = new ResultMap();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date startdate = format.parse(start);
            Date enddate  = format.parse(end);
            List<Price> list = priceService.findPriceByConditions(price,startdate,enddate);
            map.Success();
            map.setData(list);
            return map;
        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
            return map;
        }
    }

}
