package com.javaniuniu.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * default boolean removeIf(Predicate<? super E> filter)
 * removeIf 和断定接口 Predicate 配合使用，返回 boolean 值
 */
public class RemoveIf {
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("l1");
        list.add("l2");
        System.out.println(list.toString());
        list.removeIf(s -> {
            return s.equals("l1");
        });
        System.out.println(list.toString());
    }




}
