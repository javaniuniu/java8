package com.javaniuniu.map;

import com.javaniuniu.pojo.Emp;
import one.util.streamex.EntryStream;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8合并两个Map中元素
 */
public class MergeEmp {

    private static Map<String, Emp> map1 = new HashMap<>();
    private static Map<String, Emp> map2 = new HashMap<>();

    //初始化
    static {
        Emp Emp1 = new Emp(1L, "Henry");
        map1.put(Emp1.getName(), Emp1);
        Emp Emp2 = new Emp(22L, "Annie");
        map1.put(Emp2.getName(), Emp2);
        Emp Emp3 = new Emp(8L, "John");
        map1.put(Emp3.getName(), Emp3);

        Emp Emp4 = new Emp(2L, "George");
        map2.put(Emp4.getName(), Emp4);
        Emp Emp5 = new Emp(3L, "Henry");
        map2.put(Emp5.getName(), Emp5);
        // Emp1 和 Emp5在map中有完全相同的key（name）

//        Emp Emp6 = new Emp(4L, "Henry");
//        map2.put(Emp6.getName(), Emp6);

    }


    // Map.merge() 方法
    @Test
    public void methodTest1() {

        // 合并到map2中 表示如果出现同样的key map1中的数据覆盖map2中的数据
        // v1 =  oldValue 在这里指的是 map2
        // v2 =  newValue 在这里指的是 map1
        // value = newValue 即指的是   map1
        map1.forEach((key, value) -> map2.merge(key, value, (v1, v2) -> new Emp(v1.getId(), v2.getName())));

        // v2.getId()>v1.getId()?v2.getId():v1.getId() 通过三木运算 可以插入 id 较大的指 到 map2 中

        System.out.println(map2);
    }

    // Stream.concat() 方法
    @Test
    public void methodTest2() {

        Map<String, Emp> result1 = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (value1, value2) -> new Emp(value2.getId(), value1.getName())));
        System.out.println(result1);
    }

    // Stream.of() 方法
    @Test
    public void methodTest3() {

        Map<String, Emp> map3 = Stream.of(map1, map2)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> new Emp(v1.getId(), v2.getName())));

        System.out.println(map3);
    }

    // Simple Streaming 方法
    @Test
    public void methodTest4() {

        Map<String, Emp> map3 = map2.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> new Emp(v1.getId(), v2.getName()),
                        () -> new HashMap<>(map1)));

        System.out.println(map3);
    }

    // StreamEx 方法
    @Test
    public void methodTest5() {
        Map<String, Emp> map3 = EntryStream.of(map1)
                .append(EntryStream.of(map2))
                .toMap((e1, e2) -> e1);
        System.out.println(map3);
    }
}
