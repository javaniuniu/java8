package com.javaniuniu.map;

import com.javaniuniu.pojo.StudentScore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流运算 +  merge
 */
public class StudentScoreTest {
    private static final List<StudentScore> list;
    static {
        list = new ArrayList<>();
        list.add(new StudentScore(1, "chinese", 110));
        list.add(new StudentScore(1, "english", 120));
        list.add(new StudentScore(1, "math", 135));
        list.add(new StudentScore(2, "chinese", 99));
        list.add(new StudentScore(2, "english", 100));
        list.add(new StudentScore(2, "math", 133));
        list.add(new StudentScore(3, "chinese", 88));
        list.add(new StudentScore(3, "english", 140));
        list.add(new StudentScore(3, "math", 90));
        list.add(new StudentScore(4, "chinese", 108));
        list.add(new StudentScore(4, "english", 123));
        list.add(new StudentScore(4, "math", 114));
        list.add(new StudentScore(5, "chinese", 116));
        list.add(new StudentScore(5, "english", 133));
        list.add(new StudentScore(5, "math", 135));
    }

    @Test
    public void sum(){
        Map<Integer,Integer> map = new HashMap<>();
        list.stream().forEach(studentScore ->
                map.merge(studentScore.getSid(),studentScore.getScore(),Integer::sum));
        System.out.println(map);

    }
}
