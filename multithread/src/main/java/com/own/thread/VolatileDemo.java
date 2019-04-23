package com.own.thread;

/**
 * 当使用server模式启动时，不会停止 ，加入关键字 volatile即可
 */
public class VolatileDemo {

    volatile private boolean isFlag = true;

    public void runMethod() {
        while (isFlag) {

        }
        System.out.println("跳出循环");
    }

    public void stopMethod() {
        isFlag = false;
    }

    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();
        ThreadAA threadAA = new ThreadAA(volatileDemo);
        ThreadBB threadBB = new ThreadBB(volatileDemo);
        threadAA.start();
        threadBB.start();
        System.out.println("已经通知停止");
    }
}

class ThreadAA extends Thread {

    private VolatileDemo volatileDemo;

    public ThreadAA(VolatileDemo volatileDemo) {
        this.volatileDemo = volatileDemo;
    }

    @Override
    public void run() {
        volatileDemo.runMethod();

    }
}

class ThreadBB extends Thread {

    private VolatileDemo volatileDemo;

    public ThreadBB(VolatileDemo volatileDemo) {
        this.volatileDemo = volatileDemo;
    }

    @Override
    public void run() {
        volatileDemo.stopMethod();

    }
}
