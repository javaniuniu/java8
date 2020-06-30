package com.javaniuniu.util;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法拦截器
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("方法："+method.getName()+"开始执行");
        //注意这里的方法调用，不是用反射哦！！！
        Object object = methodProxy.invokeSuper(obj, args);
        long end = System.currentTimeMillis();
        System.out.println("用时："+ (end-start) + " ms");
        return object;
    }
}
