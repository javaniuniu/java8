package com.javaniuniu.optional;

import com.javaniuniu.common.Result;
import com.javaniuniu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * @auther: minp
 * @date: 2020/10/18 3:53 PM
 */
@Slf4j
public class OptionalUserTest {
    private Result<User> result1;
    private Result<User> result2;
    private Result<User> result3;
    private User user1;
    private User user2;
    private User user3;
    private String name;

    @Before
    public void before() {
        log.info("=============before,初始化User=============");
        user1 = new User().setId(1).setAge(18);
        user1.setName("大师兄");
        result1 = Result.succeed(user1, "调用User1成功");

        user2 = new User().setId(1).setAge(18);
        result2 = Result.succeed(user2, "调用User2成功");

        user3 = new User();
//        name = "寻找大师兄";
    }
    /**
     * 测试 set
     *
     * @throws Exception
     */
    @Test
    public void testSetUser() throws Exception {
        User optional = Optional.ofNullable(user1)
                .map(res -> res.setAge(12))
                .orElseThrow(() -> new Exception("User 数据为空"));
        System.out.printf(optional.toString());

    }

    /**
     * 测试 result 为空
     *
     * @throws Exception
     */
    @Test
    public void testGetUser() throws Exception {
        User optional = Optional.ofNullable(result3)
                .map(res -> res.getDatas())
                .orElseThrow(() -> new Exception("User 数据为空"));
        System.out.printf(optional.toString());

    }

    /**
     * 测试 实体里参数 为空
     *
     * @throws Exception
     */
    @Test
    public void testGetUserName() throws Exception {
        String optional = Optional.ofNullable(result2)
                .map(res -> res.getDatas())
                .map(u -> u.getName())
//                .orElse("三师弟");
                .orElseGet(() -> "二师兄");
//                .orElseThrow(()->new Exception("用户名为空异常"));
        System.out.printf(optional);
    }

    /**
     * 测试 name
     *
     * @throws Exception
     */
    @Test
    public void testGetName() throws Exception {
        String optional = Optional.ofNullable(name)
                .orElse("三师弟");
//                .orElseGet(()->"二师兄");
        System.out.printf(optional);
    }
}
