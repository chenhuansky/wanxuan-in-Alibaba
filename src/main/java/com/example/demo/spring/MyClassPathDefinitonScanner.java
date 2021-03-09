package com.example.demo.spring;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-03-08 17:43
 * @time 17:43
 * @description
 */
class MyClassPathDefinitonScanner extends ClassPathBeanDefinitionScanner {
    private List<Class> typeList;
    public MyClassPathDefinitonScanner(BeanDefinitionRegistry registry,Class<? extends Annotation>... type){
        super(registry,false);
        this.typeList = Arrays.asList(type);
    }
    /**
     * 注册 过滤器
     */
    public void registerTypeFilter(){
        for (Class type: typeList) {
            addIncludeFilter(new AnnotationTypeFilter(type));
        }
    }
}