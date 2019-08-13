package com.demo.service.serviceImpl;

import com.demo.service.StockSercive;
import com.demo.stock.mapper.StockMapper;
import com.demo.stock.pojo.Stock;
import com.demo.stock.pojo.StockExample;
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
}
