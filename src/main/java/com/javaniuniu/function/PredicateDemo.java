package com.javaniuniu.function;

import java.util.function.Predicate;

/**
 * 断定型接口:有输入，有返回 只能是一个布尔值
 */
public class PredicateDemo {
    public static void main(String[] args) {
        // 判断字符串是否为空
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };
        Predicate<String> predicate = (str) -> {return str.isEmpty();};
        System.out.println(predicate.test(""));
    }
}
