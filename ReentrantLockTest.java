package com.github7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
   Author:linrui
   Date:2019/8/1
   Content:ReentrantLock
*/
class Girl {
}

class Boy {
}

public class ReentrantLockTest {
    public static void main(String[] args) {
        Lock boylock = new ReentrantLock();
        Lock girllock = new ReentrantLock();
        Thread boyThread = new Thread(
                () -> {
                    try {
                        boylock.lockInterruptibly();
                        System.out.println("i am boy");
                        //支持超时，非阻塞式获取锁，获取锁返回true
                        if (girllock.tryLock(2,TimeUnit.SECONDS)) {
                            System.out.println("获取girl 锁成功");
                        } else {
                            System.out.println("获取girl锁失败");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        boylock.unlock();
                    }

                }
        );
        Thread girlThread = new Thread(
                () -> {
                    try {
                        girllock.lockInterruptibly();
                        System.out.println("i am girl");
                        //非阻塞式获取锁，获取锁返回true
                        if (boylock.tryLock()) {
                            System.out.println("获取boy 锁成功");
                        } else {
                            System.out.println("获取boy锁失败");
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        girllock.unlock();
                    }
                }
        );
        boyThread.start();
        girlThread.start();
    }
}