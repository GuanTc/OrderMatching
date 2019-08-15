package com.demo.entities;

import com.demo.BuyOrderBook.mapper.BuyOrderBookMapper;
import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.SellOrderBook.mapper.SellOrderBookMapper;
import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.WebSocket.MyWebSocket;
import com.demo.common.ResultMap;
import com.demo.orders.mapper.OrdersMapper;
import com.demo.orders.pojo.Orders;
import com.demo.stock.mapper.StockMapper;
import com.demo.stock.pojo.Stock;
import com.demo.trade.mapper.TradeMapper;
import com.demo.trade.pojo.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Component
public class Matching {
    private static long marketOrderEachSleep=10000L;
    private static long otherOrderEachSleep=20000L;


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
        while (true) {
            //Get all stocks from stock table
            List<Stock> stockList = stockMapper.selectList();
            for (int i = 0; i < stockList.size(); i++) {
                Long stockId = stockList.get(i).getStockId();
                //firstly,check the market orders
                List<Orders> marketOrderList=ordersMapper.getOrderNotTrade(stockId,"MKT");
                if(marketOrderList!=null&&marketOrderList.size()!=0){
                    //do matching for market orders
                    for(int j=0;j<marketOrderList.size();j++){
                        Orders marketOrder=marketOrderList.get(j);
                        while(marketOrder!=null) {
                            int flag=0;
                            if (marketOrder.getType().equals("B")) {
                                //market order is buy
                                SellOrderBook sob = sellOrderBookMapper.selectMinCurrentPrice(stockId);
                                if (sob != null) {
                                    Orders sellOrder = ordersMapper.selectByPrimaryKey(sob.getOrderId());
                                    Orders buyOrder = marketOrder;
                                    if (buyOrder.getFullOrKill() == 1 && buyOrder.getRemainQty() > sellOrder.getRemainQty() ||
                                            sellOrder.getFullOrKill() == 1 && sellOrder.getRemainQty() > buyOrder.getRemainQty()) {
                                        //Full of Kill is not meet
                                        System.out.println("The order of Full or Kill can't matching");
                                    } else if(buyOrder.getUserId()==sellOrder.getUserId()) {
                                        System.out.println("Buy and Sell is the same person");
                                    }else{
                                        //the orders matching
                                        //send matching sell first line
                                        ResultMap map = new ResultMap();
                                        map.Success();
                                        map.setData(sob);
                                        map.setMsg("right");
                                        try {
                                            MyWebSocket.sendInfoJson(map);
                                            Thread.sleep(3000);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        int tradeQty = 0;
                                        if (buyOrder.getRemainQty() < sellOrder.getRemainQty()) {
                                            tradeQty = buyOrder.getRemainQty();
                                            ordersMapper.updateOrderFinished(buyOrder.getOrderId(), 0, 2, new Date());
                                            ordersMapper.updateOrderFinished(sellOrder.getOrderId(), sellOrder.getRemainQty() - buyOrder.getRemainQty(), 1, new Date());
                                            sellOrderBookMapper.updateSellSizeByOrderId(sellOrder.getRemainQty() - buyOrder.getRemainQty(), sellOrder.getOrderId());
                                        } else if (buyOrder.getRemainQty() == sellOrder.getRemainQty()) {
                                            tradeQty = buyOrder.getRemainQty();
                                            ordersMapper.updateOrderFinished(buyOrder.getOrderId(), 0, 2, new Date());
                                            ordersMapper.updateOrderFinished(sellOrder.getOrderId(), 0, 2, new Date());
                                            sellOrderBookMapper.deleteByOrderId(sellOrder.getOrderId());
                                        } else {
                                            tradeQty = sellOrder.getRemainQty();
                                            ordersMapper.updateOrderFinished(buyOrder.getOrderId(), buyOrder.getRemainQty() - sellOrder.getRemainQty(), 1, new Date());
                                            ordersMapper.updateOrderFinished(sellOrder.getOrderId(), 0, 2, new Date());
                                            sellOrderBookMapper.deleteByOrderId(sellOrder.getOrderId());
                                            marketOrder.setRemainQty(buyOrder.getRemainQty() - sellOrder.getRemainQty());
                                            flag=1;
                                        }
                                        //insert into trade table
                                        Trade trade = new Trade();
                                        trade.setUserId(buyOrder.getUserId());
                                        trade.setStockId(stockId);
                                        trade.setBuyOrderId(buyOrder.getOrderId());
                                        trade.setSellOrderId(sellOrder.getOrderId());
                                        trade.setPrice(sellOrder.getPrice());
                                        trade.setQty(tradeQty);
                                        trade.setTradeDate(new Date());
                                        tradeMapper.insert(trade);
                                        map.setData(sellOrderBookMapper.findAll());
                                        map.setMsg("Sell");
                                        try {
                                            MyWebSocket.sendInfoJson(map);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if(flag==0){
                                        marketOrder=null;
                                    }
                                }
                            }else{
                                //market order is sell
                                BuyOrderBook bob = buyOrderBookMapper.selectMaxCurrentPrice(stockId);
                                if (bob != null) {
                                    Orders buyOrder = ordersMapper.selectByPrimaryKey(bob.getOrderId());
                                    Orders sellOrder = marketOrder;
                                    if (buyOrder.getFullOrKill() == 1 && buyOrder.getRemainQty() > sellOrder.getRemainQty() ||
                                            sellOrder.getFullOrKill() == 1 && sellOrder.getRemainQty() > buyOrder.getRemainQty()) {
                                        //Full of Kill is not meet
                                        System.out.println("The order of Full or Kill can't matching");
                                    } else if(buyOrder.getUserId()==sellOrder.getUserId()) {
                                        System.out.println("Buy and Sell is the same person");
                                    }else{
                                        //the orders matching
                                        //send matching buy first line
                                        ResultMap map = new ResultMap();
                                        map.Success();
                                        map.setData(bob);
                                        map.setMsg("left");
                                        try {
                                            MyWebSocket.sendInfoJson(map);
                                            Thread.sleep(3000);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        int tradeQty = 0;
                                        if (buyOrder.getRemainQty() < sellOrder.getRemainQty()) {
                                            tradeQty = buyOrder.getRemainQty();
                                            ordersMapper.updateOrderFinished(buyOrder.getOrderId(), 0, 2, new Date());
                                            ordersMapper.updateOrderFinished(sellOrder.getOrderId(), sellOrder.getRemainQty() - buyOrder.getRemainQty(), 1, new Date());
                                            buyOrderBookMapper.deleteByOrderId(buyOrder.getOrderId());
                                            marketOrder.setRemainQty(sellOrder.getRemainQty() - buyOrder.getRemainQty());
                                            flag=1;
                                        } else if (buyOrder.getRemainQty() == sellOrder.getRemainQty()) {
                                            tradeQty = buyOrder.getRemainQty();
                                            ordersMapper.updateOrderFinished(buyOrder.getOrderId(), 0, 2, new Date());
                                            ordersMapper.updateOrderFinished(sellOrder.getOrderId(), 0, 2, new Date());
                                            buyOrderBookMapper.deleteByOrderId(buyOrder.getOrderId());
                                        } else {
                                            tradeQty = sellOrder.getRemainQty();
                                            ordersMapper.updateOrderFinished(buyOrder.getOrderId(), buyOrder.getRemainQty() - sellOrder.getRemainQty(), 1, new Date());
                                            ordersMapper.updateOrderFinished(sellOrder.getOrderId(), 0, 2, new Date());
                                            buyOrderBookMapper.updateBuySizeByOrderId(buyOrder.getRemainQty() - sellOrder.getRemainQty(),buyOrder.getOrderId());
                                        }
                                        //insert into trade table
                                        Trade trade = new Trade();
                                        trade.setUserId(buyOrder.getUserId());
                                        trade.setStockId(stockId);
                                        trade.setBuyOrderId(buyOrder.getOrderId());
                                        trade.setSellOrderId(sellOrder.getOrderId());
                                        trade.setPrice(buyOrder.getPrice());
                                        trade.setQty(tradeQty);
                                        trade.setTradeDate(new Date());
                                        tradeMapper.insert(trade);
                                        map.setData(buyOrderBookMapper.findAll());
                                        map.setMsg("Buy");
                                        try {
                                            MyWebSocket.sendInfoJson(map);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        try {
                                            Thread.sleep(marketOrderEachSleep);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if(flag==0){
                                        marketOrder=null;
                                    }
                                }
                            }
                        }
                    }
                }
                //Market orders has finished, next is other orders
                BuyOrderBook bob = buyOrderBookMapper.selectMaxCurrentPrice(stockId);
                SellOrderBook sob = sellOrderBookMapper.selectMinCurrentPrice(stockId);
                if (bob != null && sob != null && Math.abs(bob.getBuyPrice()-sob.getAskPrice())<0.00000001) {
                    Orders buyOrder = ordersMapper.selectByPrimaryKey(bob.getOrderId());
                    Orders sellOrder = ordersMapper.selectByPrimaryKey(sob.getOrderId());
                    if (buyOrder.getFullOrKill() == 1 && buyOrder.getRemainQty() > sellOrder.getRemainQty() ||
                            sellOrder.getFullOrKill() == 1 && sellOrder.getRemainQty() > buyOrder.getRemainQty()) {
                        //Full of Kill is not meet
                        System.out.println("The order of Full or Kill can't matching");
                    } else if(buyOrder.getUserId()==sellOrder.getUserId()) {
                        System.out.println("Buy and Sell is the same person");
                    }else {
                        //the orders matching
                        //send matching buy first line
                        ResultMap map = new ResultMap();
                        map.Success();
                        map.setData(bob);
                        map.setMsg("left");
                        try {
                            MyWebSocket.sendInfoJson(map);
                            map.setData(sob);
                            map.setMsg("right");
                            MyWebSocket.sendInfoJson(map);
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        int tradeQty = 0;
                        if (buyOrder.getRemainQty() < sellOrder.getRemainQty()) {
                            tradeQty = buyOrder.getRemainQty();
                            ordersMapper.updateOrderFinished(buyOrder.getOrderId(), 0, 2, new Date());
                            ordersMapper.updateOrderFinished(sellOrder.getOrderId(), sellOrder.getRemainQty() - buyOrder.getRemainQty(), 1, new Date());
                            sellOrderBookMapper.updateSellSizeByOrderId (sellOrder.getRemainQty() - buyOrder.getRemainQty(), sellOrder.getOrderId());
                            buyOrderBookMapper.deleteByOrderId(buyOrder.getOrderId());
                        } else if (buyOrder.getRemainQty() == sellOrder.getRemainQty()) {
                            tradeQty = buyOrder.getRemainQty();
                            ordersMapper.updateOrderFinished(buyOrder.getOrderId(), 0, 2, new Date());
                            ordersMapper.updateOrderFinished(sellOrder.getOrderId(), 0, 2, new Date());
                            sellOrderBookMapper.deleteByOrderId(sellOrder.getOrderId());
                            buyOrderBookMapper.deleteByOrderId(buyOrder.getOrderId());
                        } else {
                            tradeQty = sellOrder.getRemainQty();
                            ordersMapper.updateOrderFinished(buyOrder.getOrderId(), buyOrder.getRemainQty() - sellOrder.getRemainQty(), 1, new Date());
                            ordersMapper.updateOrderFinished(sellOrder.getOrderId(), 0, 2, new Date());
                            buyOrderBookMapper.updateBuySizeByOrderId(buyOrder.getRemainQty() - sellOrder.getRemainQty(), buyOrder.getOrderId());
                            sellOrderBookMapper.deleteByOrderId(sellOrder.getOrderId());
                        }
                        //insert into trade table
                        Trade trade = new Trade();
                        trade.setUserId(buyOrder.getUserId());
                        trade.setStockId(stockId);
                        trade.setBuyOrderId(buyOrder.getOrderId());
                        trade.setSellOrderId(sellOrder.getOrderId());
                        trade.setPrice(sellOrder.getPrice());
                        trade.setQty(tradeQty);
                        trade.setTradeDate(new Date());
                        tradeMapper.insert(trade);
                        map.setData(sellOrderBookMapper.findAll());
                        map.setMsg("Sell");
                        try {
                            MyWebSocket.sendInfoJson(map);
                            map.setData(buyOrderBookMapper.findAll());
                            map.setMsg("Buy");
                            MyWebSocket.sendInfoJson(map);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }//price is same,do the matching end
            }//for stock end
        }
    }
}
