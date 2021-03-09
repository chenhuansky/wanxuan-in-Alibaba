package com.example.demo.service;

import java.util.Random;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-01-28 20:57
 * @time 20:57
 * @description
 */
public final class RandomNameFactory {
    private static final Random random = new Random();
    public static String getRandom() {
        return "Hello random " + random.nextInt();
    }
}
