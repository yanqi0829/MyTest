package com.yanqi.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class LogException implements ThrowsAdvice {
    //异常通知的具体方法
      public   void afterThrowing(Method method, Object[] args, Object target,Throwable throwable){
        System.out.println( "异常通知：目标对象target"+target+"调用的方法名"+method.getName()+"方法参数"+args+"异常"+throwable.getMessage());


    }
}
