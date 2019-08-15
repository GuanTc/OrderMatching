package com.demo.service.serviceImpl;

import com.demo.SellOrderBook.mapper.SellOrderBookMapper;
import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.SellOrderBook.pojo.SellOrderBookExample;
import com.demo.service.SellOrderBookService;
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
public class SellOrderBookServiceImpl implements SellOrderBookService {
    @Autowired
    private SellOrderBookMapper sellOrderBookMapper;

    @Override
    @Transactional
    public void addSellOrderBook(SellOrderBook sellOrderBook) {
        sellOrderBookMapper.insert(sellOrderBook);
    }

    @Override
    public SellOrderBook findMinPrice(Long StockId) {
        List<SellOrderBook> result = sellOrderBookMapper.findMinPrice(StockId);
        return result.get(0);
    }

    @Override
    @Transactional
    public void deleteSellOrderBook(Long SobId) {
        SellOrderBookExample example = new SellOrderBookExample();
        SellOrderBookExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(SobId);
        sellOrderBookMapper.deleteByExample(example);
    }

    @Override
    @Transactional
    public void updateSellOrderBook(SellOrderBook sellOrderBook) {
        sellOrderBookMapper.updateByPrimaryKey(sellOrderBook);
    }

    @Override
    public List<SellOrderBook> findAll() {
        return sellOrderBookMapper.findAll();
    }

    @Override
    public SellOrderBook findMinPriceByStockId(Long stockId) {
        return sellOrderBookMapper.selectMinCurrentPrice(stockId);
    }
}
