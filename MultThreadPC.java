package com.github7;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
   Author:linrui
   Date:2019/8/1
   Content:
*/
class Goods{
    private  int maxgoods;
    private int currentgoods;
    private Lock lock=new ReentrantLock();
    //生产者队列
    private Condition productQueue=lock.newCondition();
    //消费者队列
    private Condition consumerQueue=lock.newCondition();

    public Goods(int maxgoods) {
        this.maxgoods = maxgoods;
    }

    public void productGoods() throws InterruptedException {
        lock.lock();
        while (this.currentgoods==maxgoods){
            productQueue.await();
        }
        currentgoods++;
        //唤醒消费者线程
        consumerQueue.signalAll();
        lock.unlock();
    }
}


public class MultThreadPC {

}
