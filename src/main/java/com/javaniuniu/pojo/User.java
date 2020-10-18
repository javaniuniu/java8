package com.javaniuniu.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @auther: javaniuniu
 * @date: 2020/7/1 12:04 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User {

    @NotNull(message = "用户ID不能为空")
    private int id;
    private String name;
    private int age;


    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
