package com.demo.stock.mapper;

import com.demo.stock.pojo.Stock;
import com.demo.stock.pojo.StockExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StockMapper {
    int countByExample(StockExample example);

    int deleteByExample(StockExample example);

    int deleteByPrimaryKey(Long stockId);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    Stock selectByPrimaryKey(Long stockId);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);

    List<Stock> selectList();

    List<Stock> findAll();
}