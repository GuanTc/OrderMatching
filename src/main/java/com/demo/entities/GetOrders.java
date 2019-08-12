package com.demo.entities;

import com.demo.orders.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetOrders {

    @Autowired
    private OrdersMapper ordersMapper;

    public void getOrder(){
        //get orders from Orders table
        int id=-1;
        while(true){
        }
    }
}
