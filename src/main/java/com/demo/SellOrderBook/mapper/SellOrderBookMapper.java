package com.demo.SellOrderBook.mapper;

import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.SellOrderBook.pojo.SellOrderBookExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SellOrderBookMapper {
    int countByExample(SellOrderBookExample example);

    int deleteByExample(SellOrderBookExample example);

    int deleteByPrimaryKey(Long sobId);

    int insert(SellOrderBook record);

    int insertSelective(SellOrderBook record);

    List<SellOrderBook> selectByExample(SellOrderBookExample example);

    SellOrderBook selectByPrimaryKey(Long sobId);

    int updateByExampleSelective(@Param("record") SellOrderBook record, @Param("example") SellOrderBookExample example);

    int updateByExample(@Param("record") SellOrderBook record, @Param("example") SellOrderBookExample example);

    int updateByPrimaryKeySelective(SellOrderBook record);

    int updateByPrimaryKey(SellOrderBook record);

    SellOrderBook selectMinCurrentPrice(Long stockId);

    void updateAskSize(@Param("remainQty")int remainQty, @Param("sobId")Long sobId);

    void deleteByOrderId(Long orderId);

    void updateSellSizeByOrderId(@Param("remainQty")int remainQty, @Param("orderId")Long orderId);

    List<SellOrderBook> findMinPrice(Long stockId);

    List<SellOrderBook> findAll();
}