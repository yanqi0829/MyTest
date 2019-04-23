package com.own.communicate;

/**
 * 线程通信 经典案例:生产者与消费者
 */
public class ProducerAndConsumer {
/*普通的方案会出现性别紊乱问题
* 解决方案： 只要保证生产姓名和性别的过程保持同步，中间不能被消费者线程进来
* 应该交替出现一个数据，消费一个数据
* 解决方案：使用等待唤醒机制
* */

    public static void main(String[] args) {
        //共享的资源对象
        Resource resource = new Resource();
        Producer p= new Producer(resource);
        Thread p1= new Thread(p);
        p1.start();

        Consumer c= new Consumer(resource);
        Thread c1= new Thread(c);
        c1.start();
    }
}


class Producer implements  Runnable{
    //共享对象
    Resource resource=null;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i=0;i<50;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i%2==0){
                resource.push("小强","男");
            }
            else{
                resource.push("小红","女");
            }

        }

    }
}

class Consumer implements  Runnable{
    //共享对象
    Resource resource=null;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i=0;i<50;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        resource.pop();
        }
    }
}



    class Resource {
    private String name;
    private String gender;
    private  boolean isEmpty;//表示共享数据是否为空

    public synchronized void push(String name, String gender) {
        while(!isEmpty){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.name = name;
        this.gender = gender;
        isEmpty=false;
        this.notifyAll();
    }

    public  synchronized void pop(){
        while(isEmpty){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name+"...."+this.gender);
        isEmpty=true;
        this.notifyAll();
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
