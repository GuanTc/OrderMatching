package com.demo.service.serviceImpl;

import com.demo.service.StockSercive;
import com.demo.stock.mapper.StockMapper;
import com.demo.stock.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public int addStock(Stock stock) {


       return 0;
    }

    @Override
    public List<Stock> findAll() {
        return null;
    }

    @Override
    public List<Stock> findStockByConditions(Stock stock) {
        return null;
    }
}
