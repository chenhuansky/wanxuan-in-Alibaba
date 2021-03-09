package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-01-28 15:37
 * @time 15:37
 * @description
 */

@Component("exampleOneService")
public class ExampleOneService implements  MessageService{
    static {
        System.out.println("ExampleOneService:         Static Part start");
    }
    public ExampleOneService (){
        System.out.println("ExampleOneService:          construct new");
    }

   // @Value("${name}")
    //private String message;

    @Override
    public String getMessage(){
        return null;
        //return message;
    }

}
