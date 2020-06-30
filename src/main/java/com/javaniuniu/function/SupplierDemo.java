package com.javaniuniu.function;

import java.util.function.Supplier;

/**
 * 供给型接口，无输入，有返回
 */
public class SupplierDemo {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "1234";
//            }
//        };
        Supplier<String> supplier = () -> {return "1234";};
        System.out.println(supplier.get());
    }
}
