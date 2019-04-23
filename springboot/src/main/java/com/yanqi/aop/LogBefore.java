package com.yanqi.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
//前置通知实现接口
public class LogBefore  implements MethodBeforeAdvice{

//前置通知的具体内容
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行前置通知.....");

    }
}
