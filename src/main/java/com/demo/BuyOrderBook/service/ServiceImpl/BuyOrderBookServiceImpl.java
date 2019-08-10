package com.demo.BuyOrderBook.service.ServiceImpl;
import com.demo.BuyOrderBook.mapper.BuyOrderBookMapper;
import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.BuyOrderBook.service.BuyOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@author: WANGSHUAIYI
 *@date : 2019/8/10
 *@description:
 */

@Service
public class BuyOrderBookServiceImpl implements BuyOrderBookService {

    @Autowired
    private BuyOrderBookMapper buyOrderBookMapper;

    @Override
    @Transactional
    public void addBuyOrderBookService(BuyOrderBook buyOrderBook) {
           try {
               buyOrderBookMapper.insert(buyOrderBook);
           }catch (Exception e){
               new Throwable("插入失败");
           }

    }

    @Override
    public BuyOrderBook findTheFirstBuyOrderBook() {
        return buyOrderBookMapper.findTheFirstBuyOrderBook();
    }

    @Override
    public List<BuyOrderBook> findAll() {
        return buyOrderBookMapper.findAll();
    }

    @Override
    public void deleteBuyOrderBookById(Long id) {
            buyOrderBookMapper.deleteByPrimaryKey(id);
    }
}
