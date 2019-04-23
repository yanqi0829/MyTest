package com.own.thread;

public class Thread_1_共享数据  extends Thread{
    int count=5;

    @Override
//    public void run() {
//    ②在run方法中加synchronized，为run方法加锁，加锁的代码称为“互斥区”，“临界区”
    public synchronized void run() {
        super.run();
        //TODO i-- 分为三步：获取i i-1 对i赋值，多线程同时访问一定会出现安全问题
        count--;
        System.out.println("Thread"+Thread.currentThread().getName()+"="+count);
    }


    public static void main(String[] args) {
        Thread_1_共享数据 tt=new Thread_1_共享数据();
        Thread t1= new Thread(tt,"A");
        Thread t2= new Thread(tt,"B");
        Thread t3= new Thread(tt,"C");
        Thread t4= new Thread(tt,"D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        /**  ①执行结果：由于共享数据，产生了线程安全问题，
         * ThreadB=3
         ThreadD=1
         ThreadA=3
         ThreadC=2
         *
         * */

    }
}
