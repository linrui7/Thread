package com.github7;
/*
   Author:linrui
   Date:2019/7/31
   Content:多线程的实现
*/

class MyThread extends Thread {
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程为" + title + ":" + i);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("1");
        MyThread myThread1 = new MyThread("2");
        MyThread myThread2 = new MyThread("3");
        myThread.start();
        myThread1.start();
        myThread2.start();
    }
}
