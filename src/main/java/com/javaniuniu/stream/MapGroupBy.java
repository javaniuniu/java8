package com.javaniuniu.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * stream 流遍历 List分组Map
 */
public class MapGroupBy {
    private static final List<Map<String,Object>> lsl;
    static {
        lsl = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "zhangSan");
        lsl.add(map);



        Map<String,Object> map2 = new HashMap<>();
        map2.put("id", "2");
        map2.put("name", "lisi");
        lsl.add(map2);

        Map<String,Object> map3 = new HashMap<>();
        map3.put("id", "1");
        map3.put("name", "wangwu");

        lsl.add(map3);

        Map<String,Object> map4 = new HashMap<>();
        map4.put("id", "3");
        map4.put("name", "zhaoliu");

        lsl.add(map4);

        Map<String,Object> map5 = new HashMap<>();
        map5.put("id", "3");
        map5.put("age", "18");

        lsl.add(map5);



    }
    @Test
    public void gbTest() {
//        Function<Map<String,Object>,String> map = new Function<Map<String, Object>, String>() {
//            @Override
//            public String apply(Map<String, Object> stringObjectMap) {
//                Object object = stringObjectMap.get("id");
//                String string = object.toString();
//                return string;
//            }
//        };
        Map<String, List<Map<String, Object>>> collect = lsl.stream().collect(Collectors.groupingBy((map)->{
            return map.get("id").toString();
        }));
        System.out.println(collect);
    }

}
