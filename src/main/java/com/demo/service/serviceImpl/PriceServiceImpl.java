package com.demo.service.serviceImpl;

import com.demo.price.mapper.PriceMapper;
import com.demo.price.pojo.Price;
import com.demo.price.pojo.PriceExample;
import com.demo.service.priceService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
@Service
public class PriceServiceImpl implements priceService {
    @Autowired
    private PriceMapper priceMapper;

    @Override
    @Transactional
    public void addPrice(Price price) {

        priceMapper.insert(price);
    }

    @Override
    public List<Price> findAll() {
        return priceMapper.findAll();
    }

    @Override
    public List<Price> findPriceByConditions(Price price, Date startdate, Date enddate) {
        PriceExample example = new PriceExample();
        PriceExample.Criteria criteria = example.createCriteria();
        if(price != null){
            if(price.getStockId() != null){
                criteria.andStockIdEqualTo(price.getStockId());
            }
        }
        if(startdate != null){
            criteria.andPriceCurrentDateGreaterThanOrEqualTo(startdate);
        }
        if(enddate != null){
            criteria.andPriceCurrentDateLessThanOrEqualTo(enddate);
        }
        return priceMapper.selectByExample(example);
    }
}
