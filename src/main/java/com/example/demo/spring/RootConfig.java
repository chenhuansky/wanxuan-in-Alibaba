package com.example.demo.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
@Configuration
public class RootConfig {
    public static void main(String[] args) {

        RootConfig rootConfig = new RootConfig();
        rootConfig.testSimpleScan();
    }

    public void testSimpleScan() {
        GenericApplicationContext context = new GenericApplicationContext();
        MyClassPathDefinitonScanner myClassPathDefinitonScanner = new MyClassPathDefinitonScanner(context, MySelfBean.class, Component.class);
        // 注册过滤器
        myClassPathDefinitonScanner.registerTypeFilter();
        int beanCount = myClassPathDefinitonScanner.scan("com.example.demo");
        context.refresh();

        System.out.println(context.getBean("clinitTestFive"));
        System.out.println(context.getAutowireCapableBeanFactory().getBean("clinitTestFive"));
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(beanCount);
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}

