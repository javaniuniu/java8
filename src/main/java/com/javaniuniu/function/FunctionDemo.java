package com.javaniuniu.function;

import java.util.function.Function;

/**
 * Function 函数型接口,有输，有输出
 * 只要是 函数型接口 就可以用 lambda 表达式简化
 */
public class FunctionDemo {
    public static void main(String[] args) {
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };
        Function<String,String> function = (str)->{return str;};
        System.out.println(function.apply("ads"));
    }
}
