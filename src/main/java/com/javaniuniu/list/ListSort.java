package com.javaniuniu.list;

import com.javaniuniu.pojo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * //按照List中对象的id属性升序
 * list.sort(Comparator.comparing(Stu::getId))
 * //按照List中对象的id属性降序
 * list.sort(Comparator.comparing(Stu::getId).reversed());
 * //多条件升序
 * list.sort(Comparator.comparing(Stu::getId).thenComparing(Stu::getSid));
 * //id升序,sid降序
 * list.sort(Comparator.comparing(Stu::getId).reversed().thenComparing(Stu::getSid));
 * //key值重复的map
 * MultiValueMap<Integer, String> timeMap = new LinkedMultiValueMap<>();
 * //集合升序排序
 * Collections.sort(student, new Comparator(){
 * public int compare(StudentVo p1, StudentVo p2) {
 * return Integer.parseInt(p1.getStudentCode()) - Integer.parseInt(p2.getStudentCode());
 * }
 * });
 */

/**
 * @auther: javaniuniu
 * @date: 2020/7/1 12:27 PM
 * sort Comparator 排序
 */

public class ListSort {
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
    // ======================排序==========================

    //  给list排序
    @Test
    public void sortString() {
        System.out.println(list.toString());
//        list.sort(Comparator.comparing(String::intern));
        list.sort(Comparator.comparing(String::length));
        System.out.println(list.toString());
    }

    @Test
    public void sortInt() {
        System.out.println(listInt.toString());
        listInt.sort(Comparator.comparing(Integer::shortValue));
        System.out.println(listInt.toString());
    }

    // 根据年龄排序
    @Test
    public void sortUser() {
        System.out.println(listu.toString());
        listu.sort(Comparator.comparing(User::getAge));
        System.out.println(listu.toString());
    }

    // 多条件排序
    @Test
    public void sortUser2() {
        System.out.println(listu.toString());
        listu.sort(Comparator.comparing(User::getAge).thenComparing(User::getId));
        listu.sort(Comparator.comparing(User::getAge).reversed().thenComparing(User::getId));
        listu.sort(Comparator.comparing(User::getAge).thenComparing(User::getId).reversed());
        System.out.println(listu.toString());
    }

}
