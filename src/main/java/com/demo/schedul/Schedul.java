package com.demo.schedul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/13
 * @description:
 */
@Component
public class Schedul {
    private  static final SimpleDateFormat dataFromat = new SimpleDateFormat("HH:mm:ss");
    //秒（0-59）， 分，小时（0-23） 日期天/日（1-31） ，日期月份（1-12） 星期（1-7）年（1970-2099可以省略）
    private static final Logger logger = LoggerFactory.getLogger(Schedul.class);
    @Scheduled(cron = "0 0/2 * * * ?")
    public void start(){
        logger.info("现在时间：{}",dataFromat.format(new Date()));
    }
}
