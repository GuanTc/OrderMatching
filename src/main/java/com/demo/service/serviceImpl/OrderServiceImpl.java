package com.demo.service.serviceImpl;

import com.demo.orders.mapper.OrdersMapper;
import com.demo.orders.pojo.Orders;
import com.demo.orders.pojo.OrdersExample;
import com.demo.service.OrderService;
import com.demo.stock.mapper.StockMapper;
import com.demo.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    @Transactional
    public void addOrder(Orders orders) {

        if("Day".equals(orders.getDuration())){
                orders.setGtdDate(getDayTime());
        }else if("GTC".equals(orders.getDuration())){
                Date date = getDayTime();
                date = addDayOfDate(date,30);
                orders.setGtdDate(date);
        }

        ordersMapper.insert(orders);
    }


    public static Date addDayOfDate(Date date,int i){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, i);
        Date newDate = c.getTime();
        return newDate;
    }

    public  static Date getDayTime(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        int day=cal.get(Calendar.DATE);//获取日
        int hour = 15;
        String minute = "00";
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
}
