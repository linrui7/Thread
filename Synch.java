package com.github7;
/*
   Author:linrui
   Date:2019/8/1
   Content:
*/

class SynchronizedTest {
    public static void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "test开始");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "test结束");
    }
}

class MyThread extends Thread {
    @Override
    public synchronized void run() {
            SynchronizedTest synchronizedTest = new SynchronizedTest();
            try {
                synchronizedTest.test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}

public class Synch {
    public static void main(String[] args) {
        MyThread my=new MyThread();
        new Thread(my, "1").start();
        new Thread(my, "2").start();
        new Thread(my, "3").start();
    }
}
