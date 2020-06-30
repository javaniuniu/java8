package com.javaniuniu.map;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 初始化
 */
public class MapInitDemo {

    // 第一种方法：static块初始化
    private static final Map<String, String> myMap;
    static
    {
        myMap = new HashMap<String, String>();
        myMap.put("a", "b");
        myMap.put("c", "d");
    }

    // 第二种方法：双括号初始化 （匿名内部类）
    // 慎用， 非静态内部类/ 匿名内部类包含了外围实例的引用， 如果拥有比外部类更长的生命周期，有内存泄露隐患
    private void initTest1() {
        HashMap<String, String > h = new HashMap<String, String>(){{
            put("a","b");
        }};


    }



    @Test
    // 第三种方法：Guava
    public void initTest2() {
        // ImmutableMap，创建一个对象常量映射，来保存一些常量映射的键值对，
        // 用于定义常量 对象实例不能被更改
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        //或者
        Map<String, String> test = ImmutableMap.<String, String>builder()
                .put("k1", "v1")
                .put("k2", "v2")
                .build();
        System.out.println(test);
    }

}
