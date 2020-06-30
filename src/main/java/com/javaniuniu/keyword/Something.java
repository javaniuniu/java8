package com.javaniuniu.keyword;


import java.util.function.Function;

/**
 * `::` 关键字来访问类的构造方法，对象方法，静态方法。
 */
public class Something {

    // constructor methods
    Something() {}

    Something(String something) {
        System.out.println(something);
    }

    // static methods
    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    // object methods
    String endWith(String s) {
        return String.valueOf(s.charAt(s.length()-1));
    }

    void endWith() {}
}


//// 自定义函数是接口
//// 同 java.util.function.Function
//@FunctionalInterface
//interface IConvert<F, T> {
//    T convert(F f);
//}

class TestKey{
    public static void main(String[] args) {
        // static methods
        Function<String,String> function = Something::startsWith;
        String converted1 = function.apply("123");
        System.out.println(converted1);

        Something something = new Something();

        // object methods
        Function<String, String> function1 = something::endWith;
        String converted2 = function1.apply("Java");
        System.out.println(converted2);


        // constructor methods
        Function<String, Something> function2 = Something::new;
        Something something2 = function2.apply("constructors");
        System.out.println(something2);


    }
}