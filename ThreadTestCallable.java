package com.github7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
   Author:linrui
   Date:2019/7/31
   Content:
*/
class MythreadCallable implements Callable {
    private int ticket = 20;

    @Override
    public Object call() throws Exception {
        while (ticket > 0) {
            System.out.println("当前线程为" + Thread.currentThread().getName() + "还有" + --ticket);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "票卖完了";
    }
}

public class ThreadTestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //产生一个Callable对象
        MythreadCallable mythreadCallable = new MythreadCallable();
        //产生一个Futuretask对象
        FutureTask futureTask=new FutureTask(mythreadCallable);
        //通过线程启动
        new Thread(futureTask).start();

        System.out.println(futureTask.get());
    }
}
