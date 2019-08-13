package com.demo.SellOrderBook.mapper;

import com.demo.SellOrderBook.pojo.SellOrderBook;
import com.demo.SellOrderBook.pojo.SellOrderBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}