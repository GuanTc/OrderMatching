package com.demo;

import com.demo.entities.test1;
import com.demo.entities.test2;
import com.demo.entities.test3;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@MapperScan("com.demo.*.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(DemoApplication.class, args);
        test1 t1 = context.getBean(test1.class);
        test2 t2 = context.getBean(test2.class);
        test3 t3 = context.getBean(test3.class);
        t1.out1();
        t2.out2();
        t3.out3();
    }

}
