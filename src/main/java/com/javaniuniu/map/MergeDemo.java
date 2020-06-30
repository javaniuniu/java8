package com.javaniuniu.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Map.merge方法介绍
 * jdk8对于许多常用的类都扩展了一些面向函数，lambda表达式，方法引用的功能，使得java面向函数编程更为方便。
 * 其中Map.merge方法就是其中一个，merge方法有三个参数，key：map中的键，value：使用者传入的值，
 * remappingFunction：BiFunction函数接口(该接口接收两个值，执行自定义功能并返回最终值)。
 * 当map中不存在指定的key时，便将传入的value设置为key的值，当key存在值时，
 * 执行一个方法该方法接收key的旧值和传入的value，执行自定义的方法返回最终结果设置为key的值。
 */
public class MergeDemo {

    @Test
    public void MergeTest() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("id", 3);
        map.merge("id",2,(oldValue,newValue)->(newValue>oldValue?newValue:oldValue));
        System.out.println(map);
    }
}
