package com.javaniuniu.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * java8 在list中的应用
 * Iterator 遍历
 */
public class ListIterator {
    private static final List<String> list;
    private static final List<Integer> listInt;

    static {
        list = new ArrayList<>();
        list.add("l1");
        list.add("l2");
        list.add("l3");
        list.add("l1");

        listInt = new ArrayList<>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        listInt.add(1);
    }

    @Test
    public void test3() {
        list.forEach(s -> {
            System.out.println(s);
        });
    }


    @Test
    public void test2() {
        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining(s -> {
            System.out.println(s);
        });
    }

    // Iterator 迭代器 普通方法
    @Test
    public void test1() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
