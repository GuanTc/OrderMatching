package com.demo;

import com.demo.entities.Matching;
import com.demo.entities.MonitorOrders;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.demo.*.mapper")
public class DemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(DemoApplication.class, args);
        Matching matching=context.getBean(Matching.class);
        MonitorOrders monitorOrders=context.getBean(MonitorOrders.class);
        matching.match();
        monitorOrders.monitor();
    }

}
