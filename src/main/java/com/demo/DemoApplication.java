package com.demo;

import com.demo.entities.Matching;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@MapperScan("com.demo.*.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(DemoApplication.class, args);
     //   Matching matching=context.getBean(Matching.class);
        //GetOrders getOrders=context.getBean(GetOrders.class);
      //  matching.match();
        //getOrders.getOrder();
    }

}
