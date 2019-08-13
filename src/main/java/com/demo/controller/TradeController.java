package com.demo.controller;

import com.demo.service.TradeService;
import com.demo.trade.pojo.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String addTrade(Trade trade){
     tradeService.addTrade(trade);
     return "";
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Trade> findAll(){
     return tradeService.findAll();
    }
    @RequestMapping("/findTradesByCondition")
    @ResponseBody
    public List<Trade> findTradesByCondition(Trade trade, Date starttime, Date endtime){
        return tradeService.findTradesByCondition(trade,starttime,endtime);
    }


}
