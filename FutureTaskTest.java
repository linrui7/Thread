package com.github7;
/*
   Author:linrui
   Date:2019/8/1
   Content:
*/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableTask implements Callable<String>{
private int ticket=20;
    @Override
    public String call() throws Exception {
        for(int i=0;i<20;i++){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票，还剩"+ --ticket);
            }
        }
        return "卖完票";
    }
}
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTask callableTask=new CallableTask();
        FutureTask<String> futureTask=new FutureTask<>(callableTask);
        //类保证多线程场景下只会被执行一次
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();

    }
}
