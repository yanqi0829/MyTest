package com.own.thread;

public class ThreadState extends Thread {


    public ThreadState() {

        System.out.println("------" + "构造函数开始" + "------");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("------" + "构造函数结束" + "------");

    }

    @Override
    public void run() {

        Thread testThread = Thread.currentThread();
        System.out.println("------" + "run()开始" + "------");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("Thread.currentThread() == this : " + (Thread.currentThread() == this));
        System.out.println("------" + "run()结束" + "------");

    }

    public static void main(String[] args) {

//        ThreadState myThread = new ThreadState();
//        myThread.setName("A");
//        myThread.start();
        System.out.println("*********************************************");
        ThreadState myThread1 = new ThreadState();
        // TODO 将线程对象以构造参数的方式传递给Thread对象进行start（）启动线程,结果截然不同，可以看出继承和实现方式 的差异之处！
        Thread newThread=new Thread(myThread1);
        newThread.setName("A");
        newThread.start();



    }

}
