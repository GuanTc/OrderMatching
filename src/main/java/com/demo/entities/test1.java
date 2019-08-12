package com.demo.entities;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class test1 {

    @Async
    public void out1(){
        Trade t1=new Trade();
        while(true){
            String s1=t1.pollout();
            if(s1!=null){
                System.out.println("t1 pull value:" + s1);
            }

        }

    }

}
