package com.demo.orders.service.serviceImpl;

import com.demo.orders.mapper.OrdersMapper;
import com.demo.orders.pojo.Orders;
import com.demo.orders.pojo.OrdersExample;
import com.demo.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/11
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;


    @Override
    public List<Orders> findOrdersByConditions(Orders orders) {

        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();

        if(!"".equals(orders.getOrderType())){
            criteria.andOrderTypeEqualTo(orders.getOrderType());
        }

        return ordersMapper.selectByExample(example);
    }
}
