package com.demo.entities;

import com.demo.SellOrderBook.mapper.SellOrderBookMapper;
import com.demo.orders.mapper.OrdersMapper;
import com.demo.stock.mapper.StockMapper;
import com.demo.stock.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Matching {

    @Autowired
    private SellOrderBookMapper sellOrderBookMapper;
    @Autowired
    private StockMapper stockMapper;


    public void match(){
        float buyCurrentPrice=0f;
        float sellCurrentPrice=0f;
        while(true){
            //Get all stocks from stock table
            List<Stock> stockList=
        }
    }
}
