package com.github7;
/*
   Author:linrui
   Date:2019/8/1
   Content:创建线程池，执行Callable 任务
*/

import java.util.concurrent.*;
class CallableTaskkk implements Callable<String>{
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
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService=new ThreadPoolExecutor
                (3,Integer.MAX_VALUE,60,TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        CallableTaskkk callableTask =new CallableTaskkk();
        Future<String> submit=null;
        for(int i=0;i<3;i++){
            submit=executorService.submit(callableTask);
        }
        //get（）会阻塞当前线程直到取得Callable返回值。
        System.out.println(submit.get());

    }

    void code() throws ExecutionException, InterruptedException {
        ExecutorService executorService=new ThreadPoolExecutor
                (3,Integer.MAX_VALUE,60,TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        CallableTaskkk callableTask =new CallableTaskkk();
        Future<String> submit=null;
        for(int i=0;i<3;i++){
            submit=executorService.submit(callableTask);
            //get（）会阻塞当前线程直到取得Callable返回值。
            //在for循环中，第一个线程会执行完。其他线程才会启动。
            System.out.println(submit.get());
        }


    }
}
