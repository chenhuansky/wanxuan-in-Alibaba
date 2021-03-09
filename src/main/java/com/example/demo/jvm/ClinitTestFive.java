package com.example.demo.jvm;

import com.example.demo.spring.MySelfBean;
import lombok.Data;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-02-25 17:53
 * @time 17:53
 * @description
 */
@MySelfBean
public class ClinitTestFive {

    private static BooleanTest booleanTest;

    private static Boolean aBoolean;

    static {
        aBoolean = true;
        booleanTest = new BooleanTest(aBoolean, 23232443L);
    }

    public static void main(String[] args) {
        aBoolean = false;
        System.out.println(booleanTest.value);
    }

}

@Data
class BooleanTest {
    Boolean value;
    Long time;

    BooleanTest(Boolean value, Long time) {
        this.value = value;
        this.time = time;
    }
}