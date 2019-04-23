package com.own.thread;

public class ThreadInterrupt extends Thread {
    @Override
    public void run() {
        super.run();
//        for (int i=10;i<500000;i++){

//          System.out.println(i);
//        }

    }

    public static void main(String[] args) {
        ThreadInterrupt t=new ThreadInterrupt();
        t.start();
        //interrupt 仅仅在当前线程打了个停止的标记，并不是真正的停止
        t.interrupt();
        // 查看源码 interrupted是判断current线程的中断状态的静态方法
        System.out.println(t.interrupted());//false
        System.out.println(Thread.interrupted());//false
        System.out.println(Thread.interrupted());//false
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted()); //true  将主线程中断标记后，返回为true
        System.out.println(Thread.interrupted());//false  interrupted()方法具有清除状态的功能
        System.out.println(Thread.interrupted());//false  interrupted()方法具有清除状态的功能
        System.out.println(t.isInterrupted());// true
        System.out.println(t.isInterrupted());// true 测试线程是否是中断状态，且不清除状态标记

    }
    //TODO   使用 interrupted 与return 结合使用停止线程
    public void run1() {
        super.run();
        if(this.interrupted()){
            return;
        }

    }
}
