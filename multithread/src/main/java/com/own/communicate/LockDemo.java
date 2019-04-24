package com.own.communicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//Lock锁
class LoackDemo {
    public static void main(String[] args) {
        //共享的资源对象
        Resource1 resource = new Resource1();
        Producer1 p = new Producer1(resource);
        Thread p1 = new Thread(p);
        p1.start();

        Consumer1 c = new Consumer1(resource);
        Thread c1 = new Thread(c);
        c1.start();
    }
}


class Producer1 implements Runnable {
    //共享对象
    Resource1 resource = null;

    public Producer1(Resource1 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                resource.push("小强", "男");
            } else {
                resource.push("小红", "女");
            }

        }

    }
}

class Consumer1 implements Runnable {
    //共享对象
    Resource1 resource = null;

    public Consumer1(Resource1 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.pop();
        }
    }
}


class Resource1 {
    private String name;
    private String gender;
    private boolean isEmpty;//表示共享数据是否为空
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition condition1 = lock.newCondition();


    public void push(String name, String gender) {

        lock.lock(); //获取锁
        try {
            while (!isEmpty) {   //当不为空
                condition1.await();
            }
            this.name = name;
            Thread.sleep(10);
            this.gender=gender;
            isEmpty = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁
        }
    }

    public void pop() {
        lock.lock(); //获取锁
        try {
            while (isEmpty) {
                condition.await();
            }
            System.out.println(this.name + "...." + this.gender);
            isEmpty = true;
            condition.signalAll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}

