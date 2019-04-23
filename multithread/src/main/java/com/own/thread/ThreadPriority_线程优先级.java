package com.own.thread;

public class ThreadPriority_线程优先级  {
    public static void main(String[] args) {
        Thread1 t1=new Thread1("A");
        t1.setPriority(10);
        Thread1 t2=new Thread1("B");
        t2.setPriority(1);
        t1.start();
        t2.start();
    }

}

class Thread1 extends Thread{
    public Thread1(String name) {
        super(name);
    }
//TODO CPU会将执行资源让给优先级（1-10）比较高的线程，同时优先级可以继承
    @Override
    public void run() {
        super.run();
        for(int i=0;i<50000;i++)
        System.out.println(this.getName()+"执行了");

    }
}
