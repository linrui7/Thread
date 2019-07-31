package com.github7;
/*
   Author:linrui
   Date:2019/7/31
   Content:
*/
class ThStop implements Runnable{
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(Thread.currentThread().getName()+" "+i++);
        }
    }
}
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        ThStop thStop=new ThStop();
        Thread thread=new Thread(thStop);
        thread.start();
//        Thread.sleep(1000);
//        thStop.setFlag(false);
        thread.interrupt();

    }
}
