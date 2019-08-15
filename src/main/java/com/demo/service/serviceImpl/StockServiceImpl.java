package com.demo.service.serviceImpl;

import com.demo.BuyOrderBook.mapper.BuyOrderBookMapper;
import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.SellOrderBook.mapper.SellOrderBookMapper;
import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.common.StockPrice;
import com.demo.service.StockSercive;
import com.demo.stock.mapper.StockMapper;
import com.demo.stock.pojo.Stock;
import com.demo.stock.pojo.StockExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
@Service
public class StockServiceImpl implements StockSercive {
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private SellOrderBookMapper sellOrderBookMapper;
    @Autowired
    private BuyOrderBookMapper buyOrderBookMapper;
    @Override
    @Transactional
    public int addStock(Stock stock) {
        return stockMapper.insert(stock);
    }

    @Override
    public List<Stock> findAll() {
        return stockMapper.findAll();
    }

    @Override
    public List<Stock> findStockByConditions(Stock stock) {
        StockExample example = new StockExample();
        StockExample.Criteria criteria = example.createCriteria();

        if(stock != null){
            if(!"".equals(stock.getStockCode())){
                criteria.andStockCodeLike("%"+stock.getStockCode()+"%");
            }
        }
        return stockMapper.selectByExample(example);
    }

    @Override
    public List<StockPrice> stockPrice() {
        List<Stock> list = stockMapper.findAll();
        List<StockPrice> result = new ArrayList<>();
        for(int i =0;i<list.size();i++){
            Stock stock = list.get(i);
            StockPrice stockPrice = new StockPrice();
            stockPrice.setStockName(stock.getStockName());
            SellOrderBook sellOrderBook = sellOrderBookMapper.selectMinCurrentPrice(stock.getStockId());
            if(sellOrderBook != null&&sellOrderBook.getAskPrice() != null){
                stockPrice.setSell_price(sellOrderBook.getAskPrice());
            }
            BuyOrderBook buyOrderBook = buyOrderBookMapper.selectMaxCurrentPrice(stock.getStockId());
            if(buyOrderBook != null && buyOrderBook.getBuyPrice() != null ){
                stockPrice.setBuy_price(buyOrderBook.getBuyPrice());
            }
            result.add(stockPrice);
        }
        return result;
    }
}
