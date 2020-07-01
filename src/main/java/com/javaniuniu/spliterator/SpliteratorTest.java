package com.javaniuniu.spliterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * Spliterator并行遍历迭代器
 */
public class SpliteratorTest {
    private static final List<String> list;
    static {
        list = new ArrayList<>();
        list.add("l1");
        list.add("l2");
    }
    @Test
    public void test1() {
        list.add("l3");
        System.out.println(list.toString());

        Spliterator<String> spliterator = list.spliterator();
        // 遍历所有元素
        spliterator.forEachRemaining(s -> {
            System.out.println(s);
        });
        // 单个对元素执行给定的动作，如果有剩下元素未处理返回true，否则返回false
        boolean b = spliterator.tryAdvance(s -> {
            System.out.println(s);
        });

    }

    @Test
    public void test2() {
        List<String>  arrs = new ArrayList<>();
        arrs.add("a");
        arrs.add("b");
        arrs.add("c");
        arrs.add("d");
        arrs.add("e");
        arrs.add("f");
        arrs.add("h");
        arrs.add("i");
        arrs.add("j");
        Spliterator<String> a =  arrs.spliterator();
        //此时结果：a:0-9（index-fence）
        Spliterator<String> b = a.trySplit();
        //此时结果：b:4-9,a:0-4
        Spliterator<String> c = a.trySplit();
        //此时结果：c:4-6,b:4-9,a:6-9
        Spliterator<String> d = a.trySplit();
        //此时结果：d:6-7,c:4-6,b:4-9,a:7-9
    }


}
