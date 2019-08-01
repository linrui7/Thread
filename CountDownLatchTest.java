package com.github7;

import java.util.concurrent.CountDownLatch;

/*
   Author:linrui
   Date:2019/8/1
   Content:
   一个线程等待一组线程执行完毕后恢复执行。
    方法1：await()：等待其他线程执行完毕
    方法2：countdown（）：有线程执行完毕计数器-1
    当CountDownLatch 值减为0时无法恢复
*/
class Task implements Runnable {
    //创建计数器
    private CountDownLatch countDownLatch;
    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程");
        //计数器减少
        countDownLatch.countDown();
    }
}

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始----");
        //创建计数器为5
        CountDownLatch countDownLatch=new CountDownLatch(5);
        new Thread(new Task(countDownLatch),"线程1").start();
        new Thread(new Task(countDownLatch),"线程2").start();
        new Thread(new Task(countDownLatch),"线程3").start();
        new Thread(new Task(countDownLatch),"线程4").start();
        new Thread(new Task(countDownLatch),"线程5").start();
        //实现主线程等待其他线程都执行完再继续执行。
        countDownLatch.await();
        System.out.println("主线程执行完毕");
    }
}
