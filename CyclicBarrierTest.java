package com.github7;
/*
   Author:linrui
   Date:2019/8/1
   Content:CyclicBarrier循环栅栏
   阻塞当前线程，等待其他线程
   一组线程同时到达临界点后再同时恢复执行，先到达的会阻塞。
    所有线程到达临界点，随机挑选一个线程执行barrierAction
    调用reset()，计数器的值可以恢复。
*/


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

class CyclicBarrierTask implements Runnable{
    //创建一个循环栅栏
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("写入数据");

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+"写入完成");
            //开启栅栏
            cyclicBarrier.await();
            System.out.println("所有的都执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
public class CyclicBarrierTest {
    public static void main(String[] args) {
        //创建栅栏，传入对象
        CyclicBarrier cyclicBarrier=new CyclicBarrier(4);
        CyclicBarrierTask cyclicBarrierTask=new CyclicBarrierTask(cyclicBarrier);
        new Thread(cyclicBarrierTask,"对象1").start();
        new Thread(cyclicBarrierTask,"对象2").start();
        new Thread(cyclicBarrierTask,"对象3").start();
        new Thread(cyclicBarrierTask,"对象4").start();
    }
}
