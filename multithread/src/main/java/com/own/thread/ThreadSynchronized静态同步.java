package com.own.thread;
/* 关键字synchronized可以应用在静态方法上，对当前.java文件对应的Class类进行持锁*/
public class ThreadSynchronized静态同步 {

    public synchronized static void method1(){
        System.out.println("name1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name1");
    }

    public synchronized static void method2(){
        System.out.println("name2");
        System.out.println("name2");
    }

    public static void main(String[] args) {
        //TODO Class锁可以对类的所有实例对象起作用
        ThreadSynchronized静态同步 ttt= new ThreadSynchronized静态同步();
        ThreadA threadA = new ThreadA(ttt);
        ThreadB threadB = new ThreadB(ttt);
        threadA.start();
        threadB.start();


    }

    static class ThreadB extends Thread {
        private ThreadSynchronized静态同步 threadSynchronized;

        public ThreadB(ThreadSynchronized静态同步 threadSynchronized) {
            this.threadSynchronized = threadSynchronized;
        }

        @Override
        public void run() {
            super.run();
            threadSynchronized.method1();
        }
    }
    static class ThreadA extends Thread {
        private ThreadSynchronized静态同步 threadSynchronized;

        public ThreadA(ThreadSynchronized静态同步 threadSynchronized) {
            this.threadSynchronized = threadSynchronized;
        }

        @Override
        public void run() {
            super.run();
            threadSynchronized.method2();
        }
    }



}
