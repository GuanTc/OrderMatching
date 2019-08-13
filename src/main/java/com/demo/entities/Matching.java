package com.demo.entities;

import com.demo.BuyOrderBook.mapper.BuyOrderBookMapper;
import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.SellOrderBook.mapper.SellOrderBookMapper;
import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.orders.mapper.OrdersMapper;
import com.demo.orders.pojo.Orders;
import com.demo.stock.mapper.StockMapper;
import com.demo.stock.pojo.Stock;
import com.demo.trade.mapper.TradeMapper;
import com.demo.trade.pojo.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Matching {

    @Autowired
    private SellOrderBookMapper sellOrderBookMapper;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private BuyOrderBookMapper buyOrderBookMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private TradeMapper tradeMapper;

    @Async
    public void match() {
        //each time handling 20 rows
        int rows=20;
        while (true) {
            //Get all stocks from stock table
            List<Stock> stockList = stockMapper.selectList();
            for (int i = 0; i < stockList.size(); i++) {
                Long stockId = stockList.get(i).getStockId();
                List<Long> orderIdList = ordersMapper.getOrderIdListLimit(rows,stockId);
                for(int k=0;k<orderIdList.size();k++) {
                    //do matching for this stock
                    //get currentPrice
                    Orders order = ordersMapper.selectByPrimaryKeyAndStatus(orderIdList.get(k));
                    while (order != null) {
                        int flag = 0, isTrade = 0;
                        int tradeQty = 0;
                        if (order.getType().equals("B")) {
                            //matching for buy order
                            SellOrderBook sob = sellOrderBookMapper.selectMinCurrentPrice(stockId);
                            if(sob!=null) {
                                if (order.getFullOrKill() == 1) {
                                    //require Fill or Kill
                                    //if qty is OK
                                    tradeQty = order.getRemainQty();
                                    if (order.getRemainQty() < sob.getAskSize()) {
                                        //deal. Update order status and order book. insert this order to trade table
                                        ordersMapper.updateOrderFinished(order.getOrderId(), 0, 2, new Date());
                                        ordersMapper.updateOrderFinished(sob.getOrderId(), sob.getAskSize() - order.getRemainQty(), 1, new Date());
                                        sellOrderBookMapper.updateAskSize(sob.getAskSize() - order.getRemainQty(), sob.getSobId());
                                        buyOrderBookMapper.deleteByOrderId(order.getOrderId());
                                        flag = 1;
                                        isTrade = 1;
                                    } else if (order.getRemainQty() == sob.getAskSize()) {
                                        ordersMapper.updateOrderFinished(order.getOrderId(), 0, 2, new Date());
                                        ordersMapper.updateOrderFinished(sob.getOrderId(), 0, 2, new Date());
                                        sellOrderBookMapper.deleteByPrimaryKey(sob.getSobId());
                                        buyOrderBookMapper.deleteByOrderId(order.getOrderId());
                                        flag = 1;
                                        isTrade = 1;
                                    } else {
                                        //not matching
                                        flag = 1;
                                    }
                                } else {
                                    //not require FOK
                                    if (order.getRemainQty() < sob.getAskSize()) {
                                        tradeQty = order.getRemainQty();
                                        ordersMapper.updateOrderFinished(order.getOrderId(), 0, 2, new Date());
                                        ordersMapper.updateOrderFinished(sob.getOrderId(), sob.getAskSize() - order.getRemainQty(), 1, new Date());
                                        sellOrderBookMapper.updateAskSize(sob.getAskSize() - order.getRemainQty(), sob.getSobId());
                                        buyOrderBookMapper.deleteByOrderId(order.getOrderId());
                                        flag = 1;
                                        isTrade = 1;
                                    } else if (order.getRemainQty() == sob.getAskSize()) {
                                        tradeQty = order.getRemainQty();
                                        ordersMapper.updateOrderFinished(order.getOrderId(), 0, 2, new Date());
                                        ordersMapper.updateOrderFinished(sob.getOrderId(), 0, 2, new Date());
                                        sellOrderBookMapper.deleteByPrimaryKey(sob.getSobId());
                                        buyOrderBookMapper.deleteByOrderId(order.getOrderId());
                                        flag = 1;
                                        isTrade = 1;
                                    } else {
                                        tradeQty = sob.getAskSize();
                                        ordersMapper.updateOrderFinished(order.getOrderId(), order.getRemainQty() - sob.getAskSize(), 1, new Date());
                                        ordersMapper.updateOrderFinished(sob.getOrderId(), 0, 2, new Date());
                                        sellOrderBookMapper.deleteByPrimaryKey(sob.getSobId());
                                        buyOrderBookMapper.updateBuySizeByOrderId(order.getRemainQty() - sob.getAskSize(), order.getOrderId());
                                        order.setRemainQty(order.getRemainQty() - sob.getAskSize());
                                        isTrade = 1;
                                    }
                                }
                                if (isTrade == 1) {
                                    Trade trade = new Trade();
                                    trade.setUserId(order.getUserId());
                                    trade.setStockId(stockId);
                                    trade.setBuyOrderId(order.getOrderId());
                                    trade.setSellOrderId(sob.getOrderId());
                                    trade.setPrice(sob.getAskPrice());
                                    trade.setQty(tradeQty);
                                    trade.setTradeDate(new Date());
                                    tradeMapper.insert(trade);
                                }
                                if (flag == 1) {
                                    order = null;
                                }
                            }else{
                                order=null;
                            }
                        } else {
                            //sell orders
                            //matching for sell order
                            BuyOrderBook bob = buyOrderBookMapper.selectMaxCurrentPrice(stockId);
                            if(bob!=null) {
                                if (order.getFullOrKill() == 1) {
                                    //require Fill or Kill
                                    //if qty is OK
                                    tradeQty = order.getRemainQty();
                                    if (order.getRemainQty() < bob.getBuySize()) {
                                        //deal. Update order status and order book. insert this order to trade table
                                        ordersMapper.updateOrderFinished(order.getOrderId(), 0, 2, new Date());
                                        ordersMapper.updateOrderFinished(bob.getOrderId(), bob.getBuySize() - order.getRemainQty(), 1, new Date());
                                        buyOrderBookMapper.updateBuySize(bob.getBuySize() - order.getRemainQty(), bob.getBobId());
                                        sellOrderBookMapper.deleteByOrderId(order.getOrderId());
                                        flag = 1;
                                        isTrade = 1;
                                    } else if (order.getRemainQty() == bob.getBuySize()) {
                                        ordersMapper.updateOrderFinished(order.getOrderId(), 0, 2, new Date());
                                        ordersMapper.updateOrderFinished(bob.getOrderId(), 0, 2, new Date());
                                        buyOrderBookMapper.deleteByPrimaryKey(bob.getBobId());
                                        sellOrderBookMapper.deleteByOrderId(order.getOrderId());
                                        flag = 1;
                                        isTrade = 1;
                                    } else {
                                        //not matching
                                        flag = 1;
                                    }
                                } else {
                                    //not require FOK
                                    if (order.getRemainQty() < bob.getBuySize()) {
                                        tradeQty = order.getRemainQty();
                                        ordersMapper.updateOrderFinished(order.getOrderId(), 0, 2, new Date());
                                        ordersMapper.updateOrderFinished(bob.getOrderId(), bob.getBuySize() - order.getRemainQty(), 1, new Date());
                                        buyOrderBookMapper.updateBuySize(bob.getBuySize() - order.getRemainQty(), bob.getBobId());
                                        sellOrderBookMapper.deleteByOrderId(order.getOrderId());
                                        flag = 1;
                                        isTrade = 1;
                                    } else if (order.getRemainQty() == bob.getBuySize()) {
                                        tradeQty = order.getRemainQty();
                                        ordersMapper.updateOrderFinished(order.getOrderId(), 0, 2, new Date());
                                        ordersMapper.updateOrderFinished(bob.getOrderId(), 0, 2, new Date());
                                        buyOrderBookMapper.deleteByPrimaryKey(bob.getBobId());
                                        sellOrderBookMapper.deleteByOrderId(order.getOrderId());
                                        flag = 1;
                                        isTrade = 1;
                                    } else {
                                        tradeQty = bob.getBuySize();
                                        ordersMapper.updateOrderFinished(order.getOrderId(), order.getRemainQty() - bob.getBuySize(), 1, new Date());
                                        ordersMapper.updateOrderFinished(bob.getOrderId(), 0, 2, new Date());
                                        sellOrderBookMapper.updateSellSizeByOrderId(order.getRemainQty() - bob.getBuySize(), order.getOrderId());
                                        order.setRemainQty(order.getRemainQty() - bob.getBuySize());
                                        buyOrderBookMapper.deleteByPrimaryKey(bob.getBobId());
                                        isTrade = 1;
                                    }
                                }
                                if (isTrade == 1) {
                                    Trade trade = new Trade();
                                    Orders od = ordersMapper.selectByPrimaryKey(bob.getOrderId());
                                    trade.setUserId(od.getUserId());
                                    trade.setStockId(stockId);
                                    trade.setBuyOrderId(bob.getOrderId());
                                    trade.setSellOrderId(order.getOrderId());
                                    trade.setPrice(bob.getBuyPrice());
                                    trade.setQty(tradeQty);
                                    trade.setTradeDate(new Date());
                                    tradeMapper.insert(trade);
                                }
                                if (flag == 1) {
                                    order = null;
                                }
                            }else{
                                order=null;
                            }
                        }
                    }
                }
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
