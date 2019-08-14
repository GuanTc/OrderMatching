package com.demo.controller;

import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.common.ResultMap;
import com.demo.service.SellOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/14
 * @description:
 */
@Controller
@RequestMapping("/sellOrderBook")
public class SellOrderBookController {
    @Autowired
    private SellOrderBookService sellOrderBookService;

    @RequestMapping("/findAll")
    public ResultMap findAll(){
        ResultMap map = new ResultMap();

        try {
            List<SellOrderBook> list = sellOrderBookService.findAll();
            map.Success();
            map.setData(list);
        }catch (Exception e){
            map.Error();
        }

        return map;
    }

}
