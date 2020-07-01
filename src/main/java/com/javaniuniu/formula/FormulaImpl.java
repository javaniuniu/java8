package com.javaniuniu.formula;


/**
 * @auther: javaniuniu
 * @date: 2020/7/1 2:48 PM
 */
public class FormulaImpl {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        formula.calculate(100);     // 100.0
        formula.sqrt(16);           // 4.0
    }
}
