package com.own.thread;

/*
* 只要互相对待对方释放锁就有可能出现死锁
    使用 jps   jstack -l 14548 命令可得

Found one Java-level deadlock:
=============================
"B":
  waiting to lock monitor 0x000000000fe9d2e8 (object 0x00000007ab524078, a java.lang.Object),
  which is held by "A"
"A":
  waiting to lock monitor 0x000000000fe9fcd8 (object 0x00000007ab524088, a java.lang.Object),
  which is held by "B"

Java stack information for the threads listed above:

* */
public class Thread死锁 {
    public static void main(String[] args) {
        DealThread dealThread = new DealThread();
        Thread t1 = new Thread(dealThread,"A");
        Thread t2 = new Thread(dealThread,"B");
        t1.start();
        t2.start();

    }
}

class DealThread implements Runnable {
    Object object1 = new Object();
    Object object2 = new Object();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("A")) {
            synchronized (object1) {
                System.out.println("进入锁1");
                synchronized (object2) {
                    System.out.println("进入锁2");

                }
            }

        }
        if (Thread.currentThread().getName().equals("B")) {
            synchronized (object2) {
                System.out.println("进入锁2");
                synchronized (object1) {
                    System.out.println("进入锁1");
                }
            }

        }


    }
}

