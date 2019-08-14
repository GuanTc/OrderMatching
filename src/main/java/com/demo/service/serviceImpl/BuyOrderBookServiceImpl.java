package com.demo.service.serviceImpl;

import com.demo.BuyOrderBook.mapper.BuyOrderBookMapper;
import com.demo.BuyOrderBook.pojo.BuyOrderBook;
import com.demo.BuyOrderBook.pojo.BuyOrderBookExample;
import com.demo.service.BuyOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
@Service
public class BuyOrderBookServiceImpl implements BuyOrderBookService{
    @Autowired
    private BuyOrderBookMapper buyOrderBookMapper;

    @Override
    @Transactional
    public void addBuyOrder(BuyOrderBook buyOrderBook) {
        buyOrderBookMapper.insert(buyOrderBook);
    }

    @Override
    public List<BuyOrderBook> findAll() {
        return buyOrderBookMapper.findAll();
    }

    @Override
    public BuyOrderBook findMaxPrice(Long Sock_Id) {
        System.out.println("impl:"+Sock_Id);
        List<BuyOrderBook> result = buyOrderBookMapper.findMaxPrice(Sock_Id);
      if(result != null){
          return result.get(0);
      }else {
          return  null;
      }
    }

    @Override
    @Transactional
    public void updateBuyOrderBook(BuyOrderBook buyOrderBook) {
        buyOrderBookMapper.updateByPrimaryKey(buyOrderBook);
    }

    @Override
    @Transactional
    public void deleteBuyOrder(Long Bob) {
        BuyOrderBookExample example = new BuyOrderBookExample();
        BuyOrderBookExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(Bob);
        buyOrderBookMapper.deleteByExample(example);
    }
}
