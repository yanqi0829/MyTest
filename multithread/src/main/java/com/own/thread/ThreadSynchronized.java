package com.own.thread;

public class ThreadSynchronized {
    /**
     * 举例验证：同步方法的对象锁
     * execute method A
     * method A end
     * execute method B
     * method B end
     * 结论：A线程先持有object对象Lock锁，B线程可以异步调用object对象中的非synchronized方法
     * A线程先持有object对象Lock锁，B线程如果在此时调用object对象中的任意synchronized方法则需等待，即异步。
     */
    private String user = "A";
    private String pwd = "AA";

    public synchronized void setValue(String user, String pwd) {
        this.user = user;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pwd = pwd;
    }

    public void getValue() {
        System.out.println("user=" + user + ",pwd=" + pwd);
    }

    public synchronized void methodA() {
        System.out.println("execute method A");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method A end");
    }

    public synchronized void methodB() {
        System.out.println("execute method B");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method B end");
    }
    public synchronized void methodC() {
        System.out.println("execute method C");
        methodD();
    }

    public synchronized void methodD() {
        System.out.println("execute method D");

    }

    public static void main(String[] args) {
        ThreadSynchronized threadSynchronized = new ThreadSynchronized();
        ThreadA threadA = new ThreadA(threadSynchronized);
        ThreadB threadB = new ThreadB(threadSynchronized);
        threadA.start();
        threadB.start();
        /*脏读验证*/
        // TODO“脏读”出现在操作实例变量的情况下，就是不同线程争抢实例变量的结果，解决方法就是加上synchronized关键字
        ThreadC threadA1 = new ThreadC(threadSynchronized);
        threadA1.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadSynchronized.getValue();
        //TODO 锁重入,当一个线程获得对象锁之后，再次请求此对象锁可以再次得到该对象的锁的
        /*当存在子父类继承关系时，子类可以通过可重入锁调用父类的同步方法*/
        ThreadD threadd = new ThreadD();
        threadd.start();
    }

}

class ThreadA extends Thread {
    private ThreadSynchronized threadSynchronized;

    public ThreadA(ThreadSynchronized threadSynchronized) {
        this.threadSynchronized = threadSynchronized;
    }

    @Override
    public void run() {
        super.run();
        threadSynchronized.methodA();
    }
}

class ThreadB extends Thread {
    private ThreadSynchronized threadSynchronized;

    public ThreadB(ThreadSynchronized threadSynchronized) {
        this.threadSynchronized = threadSynchronized;
    }

    @Override
    public void run() {
        super.run();
        threadSynchronized.methodB();
    }
}

class ThreadC extends Thread {
    private ThreadSynchronized threadSynchronized;

    public ThreadC(ThreadSynchronized threadSynchronized) {
        this.threadSynchronized = threadSynchronized;
    }

    @Override
    public void run() {
        super.run();
        threadSynchronized.setValue("B", "BB");
    }
}


class ThreadD extends Thread {
    @Override
    public void run() {
        super.run();
        ThreadSynchronized threadSynchronized = new ThreadSynchronized();
        threadSynchronized.methodC();
    }
}
