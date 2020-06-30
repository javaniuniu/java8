package com.javaniuniu.util;

import com.javaniuniu.map.SumMap;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * Cglib 动态代理
 */
public class Cglib {


    @Test
    public void cTest() {
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(SumMap.class);
        //设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());
        //这里的creat方法就是正式创建代理类
        SumMap proxyMerge = (SumMap) enhancer.create();
        // 调用代理类的 sumMap 方法
        proxyMerge.sumMap1();
        proxyMerge.sumMap2();
        proxyMerge.sumMap3();
        proxyMerge.sumMap4();
        proxyMerge.sumMap5();

    }
    /*
    方法：sumMap1开始执行
    {m1=4, m2=2, m3=3}
    用时：16 ms
    方法：sumMap2开始执行
    {m1=4, m2=2, m3=3}
    用时：0 ms
    方法：sumMap3开始执行
    {m1=4, m2=2, m3=3}
    用时：52 ms
    方法：sumMap4开始执行
    {m1=4, m2=2, m3=3}
    用时：0 ms
    方法：sumMap5开始执行
    {m1=4, m2=2, m3=3}
    用时：1 ms
     */

}
