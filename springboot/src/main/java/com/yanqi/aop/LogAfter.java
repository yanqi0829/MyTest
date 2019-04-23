package com.yanqi.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LogAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println( "目标对象target"+target+"调用的方法名"+method.getName()+"方法参数"+args+"返回值"+returnValue);
    }
}
