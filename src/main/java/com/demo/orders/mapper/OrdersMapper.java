package com.demo.orders.mapper;

import com.demo.orders.pojo.Orders;
import com.demo.orders.pojo.OrdersExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrdersMapper {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    void updateOrderFinished(@Param("orderId")Long orderId, @Param("qty")int qty, @Param("i")int i, @Param("date")Date date);

    List<Orders> selectByStatus(int status);

    List<Orders> getOrderNotTrade(@Param("stockId")Long stockId, @Param("orderType")String orderType);

    List<Orders> findAll();

    void modifySendOut(@Param("orderId")Long orderId, @Param("orderType")String orderType, @Param("status")int status, @Param("date")Date date);

    void modifyLMTSendOut(@Param("orderId")Long orderId, @Param("orderType")String orderType, @Param("status")int status, @Param("limitPrice")Float limitPrice, @Param("date")Date date);
}