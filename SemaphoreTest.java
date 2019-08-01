package com.github7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
   Author:linrui
   Date:2019/8/1
   Content:Semaphore 信号量。可以指定同时执行的线程数量。
    acquire（）尝试占有一个信号量。失败的线程会阻塞，直到有新的信号量。
    release（）释放一个信号量。
    acquire（n）占有n个信号量
    release（n）释放n个信号量
*/
class SemaphoreTask implements Runnable {
    public SemaphoreTask(int numofMachine,Semaphore semaphore) {
        this.semaphore = semaphore;
        this.numofMachine=numofMachine;
    }
    int numofMachine;
    private Semaphore semaphore;

    @Override
    public void run() {

        try {
            //占有一个
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"占用机器");
            TimeUnit.SECONDS.sleep(2);
            //释放一个
            System.out.println(Thread.currentThread().getName()+"释放机器");
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreTest {
    public static void main(String[] args) {
        //传入五个信号量的对象
        int machine=2;
        Semaphore semaphore=new Semaphore(machine);
        SemaphoreTask semaphoreTask=new SemaphoreTask(machine,semaphore);
        new Thread(semaphoreTask,"工人1").start();
        new Thread(semaphoreTask,"工人2").start();
        new Thread(semaphoreTask,"工人3").start();
        new Thread(semaphoreTask,"工人4").start();
        new Thread(semaphoreTask,"工人5").start();
        new Thread(semaphoreTask,"工人6").start();
        new Thread(semaphoreTask,"工人7").start();
        new Thread(semaphoreTask,"工人8").start();
        new Thread(semaphoreTask,"工人9").start();
        new Thread(semaphoreTask,"工人10").start();
    }
}
