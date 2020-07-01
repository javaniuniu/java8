package com.javaniuniu.formula;

/**
 * @auther: javaniuniu
 * @date: 2020/7/1 2:47 PM
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

    default double sq(int a) {
        return Math.sqrt(a);
    }
}
