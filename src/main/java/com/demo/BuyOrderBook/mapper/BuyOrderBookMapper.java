package com.demo.BuyOrderBook.mapper;

import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.BuyOrderBook.pojo.BuyOrderBookExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BuyOrderBookMapper {
    int countByExample(BuyOrderBookExample example);

    int deleteByExample(BuyOrderBookExample example);

    int deleteByPrimaryKey(Long bobId);

    int insert(BuyOrderBook record);

    int insertSelective(BuyOrderBook record);

    List<BuyOrderBook> selectByExample(BuyOrderBookExample example);

    BuyOrderBook selectByPrimaryKey(Long bobId);

    int updateByExampleSelective(@Param("record") BuyOrderBook record, @Param("example") BuyOrderBookExample example);

    int updateByExample(@Param("record") BuyOrderBook record, @Param("example") BuyOrderBookExample example);

    int updateByPrimaryKeySelective(BuyOrderBook record);

    int updateByPrimaryKey(BuyOrderBook record);

    BuyOrderBook selectMaxCurrentPrice(Long stockId);

    void updateBuySize(@Param("remainQty")int remainQty, @Param("bobId")Long bobId);

    void deleteByOrderId(Long orderId);

    void updateBuySizeByOrderId(@Param("remainQty")int remainQty, @Param("orderId")Long orderId);

    List<BuyOrderBook> findAll();

    List<BuyOrderBook> findMaxPrice(Long sock_id);

}