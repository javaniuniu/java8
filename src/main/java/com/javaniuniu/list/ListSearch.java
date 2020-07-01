package com.javaniuniu.list;

import com.javaniuniu.pojo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 查询list 中字段
 */
public class ListSearch {
    private static final List<String> list;
    private static final List<Integer> listInt;
    private static final List<User> listu;

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

        listu = new ArrayList<User>();
        listu.add(new User(5, "张三", 5));
        listu.add(new User(7, "李四", 30));
        listu.add(new User(3, "王五", 19));
        listu.add(new User(2, "陈十七", 17));
        listu.add(new User(4, "陈八", 17));
        listu.add(new User(2, "陈八九十", 17));

    }
    // 根据条件查询list数组中的数据，并打印
    // 打印可通过 forEach
    @Test
    public void sortUser3() {

        System.out.println(listu.toString());
        listu.stream()
                .filter(user -> user.getAge() > 5)
                .filter(user -> user.getId() > 2)
                .sorted(Comparator.comparing(User::getAge))

                .map(user -> {
                    if (user.getName().equals("王五")) {
                        user.setName("修改后的王五");
                    }
//                    return user.getName(); // 这个返回的是String
                    return user;             // 这个返回的是 User   这个返回值可以决定 后面携带的数据 比如： sorted 比较字符串
                })
//                .sorted((uu1, uu2) -> {
//                    return uu2.compareTo(uu1);
//                })
//                .limit(1)
                .forEach(System.out::println);

    }

}
