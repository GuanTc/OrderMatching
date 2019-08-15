package com.demo.service.serviceImpl;

import com.demo.BuyOrderBook.mapper.BuyOrderBookMapper;
import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.SellOrderBook.mapper.SellOrderBookMapper;
import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.WebSocket.MyWebSocket;
import com.demo.common.ResultMap;
import com.demo.orders.mapper.OrdersMapper;
import com.demo.orders.pojo.Orders;
import com.demo.orders.pojo.OrdersExample;
import com.demo.price.mapper.PriceMapper;
import com.demo.price.pojo.Price;
import com.demo.service.OrderService;
import com.demo.stock.mapper.StockMapper;
import com.demo.user.mapper.UserMapper;
import com.demo.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/13
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private BuyOrderBookMapper buyOrderBookMapper;
    @Autowired
    private SellOrderBookMapper sellOrderBookMapper;
    @Autowired
    private PriceMapper priceMapper;


    @Override
    @Transactional
    public void addOrder( Orders orders) {

        if("Day".equals(orders.getDuration())){
               // orders.setGtdDate(getDayTime());
            Date date = getDayTime();
            date = addDayOfDate(date,10);
            orders.setGtdDate(date);
        }else if("GTC".equals(orders.getDuration())){
                Date date = getDayTime();
                date = addDayOfDate(date,5);
                orders.setGtdDate(date);
        }
        orders.setStatus(1);
        orders.setRemainQty(orders.getQty());
        orders.setSubmitDate(new Date());
        System.out.println(orders.getSubmitDate()+":::::::::::::"+orders.getGtdDate());
        ordersMapper.insert(orders);
      if(!"MKT".equals(orders.getOrderType())) {
          if("B".equals(orders.getType())){
              BuyOrderBook buyOrderBook = new BuyOrderBook();
              buyOrderBook.setStockId(orders.getStockId());
              buyOrderBook.setOrderId(orders.getOrderId());
              buyOrderBook.setBuyPrice(orders.getPrice());
              buyOrderBook.setBuySize(orders.getRemainQty());
              buyOrderBookMapper.insert(buyOrderBook);
          }

        if("S".equals(orders.getType())){
            SellOrderBook sellOrderBook = new SellOrderBook();
            sellOrderBook.setOrderId(orders.getOrderId());
            sellOrderBook.setStockId(orders.getStockId());
            sellOrderBook.setAskPrice(orders.getPrice());
            sellOrderBook.setAskSize(orders.getRemainQty());
            sellOrderBookMapper.insert(sellOrderBook);
        }
      }

//        Price price = new Price();
//        price.setStockId(orders.getStockId());
//        price.setBuyCurrentPrice(buyOrderBookMapper.selectMaxCurrentPrice(orders.getStockId()).getBuyPrice());
        try {
            ResultMap map = new ResultMap();
            map.Success();
            map.setData(buyOrderBookMapper.findAll());
            map.setMsg("Buy");
            //    String buymsg = JSONObject.toJSONString(map);
            MyWebSocket.sendInfoJson(map);
            map.setData(sellOrderBookMapper.findAll());
            //  String selmsg = JSONObject.toJSONString(map);
            map.setMsg("Sell");
            MyWebSocket.sendInfoJson(map);
        }catch (Exception e){

        }
        

        System.out.println("插入以后的OrderId: "+orders.getOrderId());
    }

//也是设置成了增加分钟
    public static Date addDayOfDate(Date date,int i){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
      //  c.add(Calendar.DATE, i);
        c.add(Calendar.MINUTE,i);
        Date newDate = c.getTime();
        return newDate;
    }
//本来应该设置为结算时间下午3点
    //但是为了能够测试我只能这只为5分钟以后
    public  static Date getDayTime(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        int day=cal.get(Calendar.DATE);//获取日
        int hour=cal.get(Calendar.HOUR);
        int minute=cal.get(Calendar.MINUTE);
        // int hour = 15;
       // String minute = "00";
        String second = "00";
        String str = ""+ year + "-"+month+"-"+day+" "+hour+":"+minute+":"+second;
        System.out.println(str);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dat = format.parse(str);
           return dat;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Orders> findAll() {

       List<Orders> list =  ordersMapper.findAll();
        for (int i=0;i<list.size();i++){
            list.get(i).setUserName(userMapper.selectByPrimaryKey( list.get(i).getUserId()).getUsername());
            list.get(i).setStockName(stockMapper.selectByPrimaryKey(list.get(i).getStockId()).getStockName());

        }
        return list;
    }

    @Override
    public List<Orders> findOrdersByCondition(Orders orders, Date startdate, Date enddate) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        if(orders != null){
            if(!"".equals(orders.getOrderType())){
                    criteria.andOrderTypeEqualTo(orders.getOrderType());
            }
            if(!"".equals(orders.getType())){
                criteria.andTypeEqualTo(orders.getType());
            }
            if(orders.getStockId() != null){
                criteria.andStockIdEqualTo(orders.getStockId());
            }
        }
        if(startdate != null){
            criteria.andSubmitDateGreaterThanOrEqualTo(startdate);
        }
        if(enddate != null){
            criteria.andSubmitDateLessThanOrEqualTo(enddate);
        }
        return ordersMapper.selectByExample(example);
    }


    @Override
    public List<Orders> findOrdersByStatis() {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andGtdDateIsNotNull();
        return ordersMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void updateOrder(Orders orders) {
        ordersMapper.updateByPrimaryKey(orders);
    }

    @Override
    public JSONObject findAllUser()  {

       JSONObject jsonObject = new JSONObject();
       List<User> list1 = userMapper.finAll();
     try {
         for(int i =0;i<list1.size();i++){
             String id = list1.get(i).getUserId()+"";
             String name=list1.get(i).getName();
             jsonObject.put(id,name);
         }
     }catch (Exception e){

     }
        return jsonObject;
    }
}
