package com.javaniuniu.stream;

import com.alibaba.fastjson.JSON;
import com.javaniuniu.pojo.Foo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream 流遍历 List分组Map
 */
public class FooTest {
    private static final List<Foo> fooList;

    static {
        fooList = new ArrayList<Foo>();
        fooList.add(new Foo("A", "san", 1.0, 2));
        fooList.add(new Foo("A", "nas", 13.0, 1));
        fooList.add(new Foo("B", "san", 112.0, 3));
        fooList.add(new Foo("C", "san", 43.0, 5));
        fooList.add(new Foo("B", "nas", 77.0, 7));
    }

    @Test
    public void fTest() {
        List<List<Foo>> groupList = new ArrayList<>();
        fooList.stream()
                .collect(Collectors.groupingBy(Foo::getName,Collectors.toList()))
                .forEach((name,fooListByName)->{
                    groupList.add(fooListByName);
                });

        System.out.println(JSON.toJSONString(groupList));


    }


}
