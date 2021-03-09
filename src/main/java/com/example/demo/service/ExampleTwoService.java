package com.example.demo.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-01-28 15:49
 * @time 15:49
 * @description
 */
@Component("exampleTwoService")
public class ExampleTwoService  implements  MessageService{

    static {
        System.out.println("ExampleTwoService           Static Part start");
    }

    public ExampleTwoService (){
        System.out.println("ExampleTwoService           construct is new");
        //Arrays.stream(("").split(",")).map(Long::parseLong).collect(Collectors.toList());
    }

    //@Value("${nameTwo}")
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}
