package com.javaniuniu.keyword;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class AcceptMethod {
    private static final AcceptMethod accept = new AcceptMethod();
 
    public static void  printValur(String str){
        System.out.println("static method print value : "+str);
    }

    public void  printValur2(String str){
        System.out.println("common method print value : "+str);
    }

    private static final List<String> al = Arrays.asList("a","b","c","d");

    // 使用关键字 :: + Stream
    @Test
    public void amTest3() {
        // Static method
        al.forEach(AcceptMethod::printValur);
        // common method
        al.forEach(accept::printValur2);
    }


    // for循环遍历 常见方法
    @Test
    public void amTest1() {

        for (String a: al) {
            AcceptMethod.printValur(a);
        }
    }

    // 使用 stream 遍历
    @Test
    public void amTest2() {
        al.forEach(x->{
            AcceptMethod.printValur(x);
        });
    }


    // 消费型接口 + Stream流接口
    @Test
    public void amTest4() {
        Consumer<String> methodParam = AcceptMethod::printValur; //方法参数
        al.forEach(x -> methodParam.accept(x));//方法执行accept
    }
}