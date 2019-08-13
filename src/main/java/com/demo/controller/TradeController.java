package com.demo.controller;

import com.demo.common.ResultMap;
import com.demo.service.TradeService;
import com.demo.trade.pojo.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
@Controller
@RequestMapping("/trade")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @RequestMapping("/add")
    @ResponseBody
    public ResultMap addTrade(Trade trade){
     ResultMap map = new ResultMap();
        try {
         tradeService.addTrade(trade);
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
            List<Trade> list = tradeService.findAll();
            map.Success();
            map.setObject(list);
        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
        }
     return map;
    }
    @RequestMapping("/findTradesByCondition")
    @ResponseBody
    public ResultMap findTradesByCondition(Trade trade, String start, String end){

        ResultMap map = new ResultMap();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startdate = null;
        Date enddate = null;
        try {
            startdate  = format.parse(start);
            enddate = format.parse(end);
            List<Trade> list = tradeService.findTradesByCondition(trade,startdate,enddate);
            map.Success();
            map.setObject(list);
        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
        }
        return map;
    }


}
