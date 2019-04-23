package com.own.thread;

/*
    同步代码块可以增加运行效率，当一个线程访问object的一个synchronized同步代码块时，另一个线程可以访问object中非synchronized代码块
    synchronized(this){} 是锁定当前对象的，当一个线程访问synchronized(this){}时，其他线程访问同一个object对象中的其他synchronized(this){}或同步方法，将被阻塞
  */
//TODO 同步代码块中锁非this对象， synchronized(非this){}与同步方法是异步的，不与其他锁this同步方法争抢this锁，则可大大提高运行效率
public class ThreadSynchronized代码块 {
}
