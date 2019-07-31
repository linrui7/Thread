package com.github7;

/*
   Author:linrui
   Date:2019/7/31
   Content:
*/
class MyThreadRun implements Runnable {
    private String title;
    private int ticket = 20;

    public MyThreadRun(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "票数为" + --ticket);

        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MyThreadRun myThread = new MyThreadRun("黄牛1");
//        MyThreadRun myThread1 = new MyThreadRun("黄牛2");
//        MyThreadRun myThread2 = new MyThreadRun("黄牛3");
        //三个线程共享一个对象
        new Thread(myThread, "黄牛1").start();
        new Thread(myThread, "黄牛2").start();
        new Thread(myThread, "黄牛3").start();
    }
}