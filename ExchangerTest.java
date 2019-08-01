package com.github7;

import java.util.concurrent.Exchanger;

/*
   Author:linrui
   Date:2019/8/1
   Content: Exchanger:交换器
   用于两个线程人之间的数据交换，当Exchanger只有一个线程时，会阻塞。
   直到有别的线程调用Exchanger进入缓冲区，交换数据后同时恢复执行。
*/
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger=new Exchanger();
        Thread Athread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String aaaa=exchanger.exchange("我是A");
                    System.out.println("A:"+aaaa);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Athread.start();
        Thread Bthread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String bbbb=exchanger.exchange("我是B");
                    System.out.println("B:"+bbbb);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Bthread.start();
    }
}
