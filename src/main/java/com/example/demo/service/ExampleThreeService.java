package com.example.demo.service;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-01-28 15:49
 * @time 15:49
 * @description
 */
@Data
@Component("exampleThreeService")
public class ExampleThreeService  implements  MessageService{

    static {
        System.out.println("ExampleThreeService          Static Part start");
    }
    public ExampleThreeService (){

        System.out.println("ExampleThreeService           construct new");
    }

    String message = "Hello 3";

    @Override
    public String getMessage() {
        return message;
    }
}
