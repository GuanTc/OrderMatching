package com.demo.service.serviceImpl;

import com.demo.orders.mapper.OrdersMapper;
import com.demo.orders.pojo.Orders;
import com.demo.service.TradeService;
import com.demo.stock.mapper.StockMapper;
import com.demo.trade.mapper.TradeMapper;
import com.demo.trade.pojo.Trade;
import com.demo.trade.pojo.TradeExample;
import com.demo.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeMapper tradeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private StockMapper stockMapper;

    @Override
    @Transactional
    public void addTrade(Trade trade) {
        tradeMapper.insert(trade);
    }

    @Override
    public List<Trade> findAll() {
        List<Trade> list = tradeMapper.findAll();
        for(int i=0;i<list.size();i++){
            Trade trade = list.get(i);
            trade.setBuyname(userMapper.selectByPrimaryKey(trade.getUserId()).getName());
            trade.setStockName(stockMapper.selectByPrimaryKey(trade.getStockId()).getStockName());
            Orders orders = ordersMapper.selectByPrimaryKey(trade.getSellOrderId());
            trade.setSellname(userMapper.selectByPrimaryKey(orders.getUserId()).getName());
        }
        return list;
    }

    @Override
    public List<Trade> findTradesByCondition(Trade trade, Date starttime, Date endtime) {
        TradeExample example = new TradeExample();
        TradeExample.Criteria criteria = example.createCriteria();
        if(trade != null){
            if(trade.getBuyOrderId() != null){
                criteria.andBuyOrderIdEqualTo(trade.getBuyOrderId());
            }
            if(trade.getSellOrderId() != null){
                criteria.andSellOrderIdEqualTo(trade.getSellOrderId());
            }
            if(trade.getStockId() != null){
                criteria.andStockIdEqualTo(trade.getStockId());
            }
        }
        if(starttime != null){
            criteria.andTradeDateGreaterThanOrEqualTo(starttime);
        }
       if(endtime != null){
           criteria.andTradeDateLessThanOrEqualTo(endtime);
       }
        return tradeMapper.selectByExample(example);
    }
}
