package com.demo.entities;

import com.demo.BuyOrderBook.mapper.BuyOrderBookMapper;
import com.demo.SellOrderBook.mapper.SellOrderBookMapper;
import com.demo.stock.mapper.StockMapper;
import com.demo.stock.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Matching {

    @Autowired
    private SellOrderBookMapper sellOrderBookMapper;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private BuyOrderBookMapper buyOrderBookMapper;


    public void match(){
        float buyCurrentPrice=0f;
        float sellCurrentPrice=0f;
        while(true){
            //Get all stocks from stock table
            List<Stock> stockList=stockMapper.selectList();
            for (int i = 0; i <stockList.size() ; i++) {
                //do matching for this stock
                //get currentPrice
                buyCurrentPrice=buyOrderBookMapper.selectMaxCurrentPrice(stockList.get(i).getStockId());
            }
        }
    }
}
