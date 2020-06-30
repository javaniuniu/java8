package com.javaniuniu.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 合并map
 */
public class SumMap {
    private static final Map<String,Integer> map1;
    private static final Map<String,Integer> map2;
    private static  Map<String,Integer> map = new HashMap<>();
    static {
        map1 = new HashMap<>();
        map1.put("m1",1);
        map1.put("m2",2);
        map2 = new HashMap<>();
        map2.put("m1",4);
        map2.put("m3",3);
    }

    // stream + merge 简化板
    @Test
    public void sumMap6() {
        // 合并到map中 表示如果出现同样的key map2中的数据覆盖map中的数据
        // oldValue      在这里指的是 map1
        // newValue      在这里指的是 map2
        // value = newValue 即指的是  map2
        map2.forEach((key,value)->map1.merge(key,value,((oldValue,newValue)->(newValue>oldValue?newValue:oldValue))));
        System.out.println(map1);
    }

    // stream + merge
    @Test
    public void sumMap3() {
        map.putAll(map1);
        // 遍历map2中的值entry，和map中的值比较 合并到map中
        // 合并到map2中 表示如果出现同样的key map1中的数据覆盖map2中的数据
        // v1 =  oldValue 在这里指的是 map2
        // v2 =  newValue 在这里指的是 map1
        // value = newValue 即指的是   map1
        map2.entrySet().stream().forEach(entry->{
            map.merge(entry.getKey(),entry.getValue(),((oldValue,newValue)->(newValue>oldValue?newValue:oldValue)));
        });


        // 简化版
        // 合并到map中 表示如果出现同样的key map2中的数据覆盖map中的数据
        // oldValue      在这里指的是 map
        // newValue      在这里指的是 map2
        // value = newValue 即指的是  map2
        map2.forEach((key,value)->map.merge(key,value,((oldValue,newValue)->(newValue>oldValue?newValue:oldValue))));
        System.out.println(map);
    }

    @Test
    public void sumMap4() {
        map2.forEach((key,value)-> {
            if(map1.containsKey(key)){
                map1.put(key,value>map1.get(key)?value:map1.get(key));
            }else {
                map1.put(key,value);
            }
        });
        System.out.println(map1);
    }

    @Test
    public void sumMap5() {
        for (Map.Entry<String, Integer>  entry : map2.entrySet()) {
            if(map1.containsKey(entry.getKey())){
                map1.put(entry.getKey(),entry.getValue()>map1.get(entry.getKey())?entry.getValue():map1.get(entry.getKey()));
            }else {
                map1.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println(map1);
    }


    @Test
    // 暴力 时间 n 空间 2n
    public void sumMap2() {
        for(String k1:map1.keySet()) {
            if (map2.containsKey(k1)){
                map2.put(k1,map2.get(k1)>map1.get(k1)?map2.get(k1):map1.get(k1));
            }else {
                map2.put(k1,map1.get(k1));
            }
        }
        System.out.println(map2);
    }

    @Test
    // 暴力 时间 n^2 空间 2n
    public void sumMap1() {
        for(String k1:map1.keySet()) {
            for (String k2:map2.keySet()) {
                if (k1.equals(k2)) {
                    if(map1.get(k1) > map2.get(k2)) {
                        map.put(k1,map1.get(k1));
                    }else {
                        map.put(k2,map2.get(k2));
                    }
                }else {
                    map.put(k1,map1.get(k1));
                    map.put(k2,map2.get(k2));
                }
            }
        }
        System.out.println(map);
    }
}
