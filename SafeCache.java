package com.github7;
/*
   Author:linrui
   Date:2019/8/1
   Content:
   可重入的读写锁ReentrantReadWriteLock
	读写锁：写写互斥，读写互斥
			A.读锁：共享锁 任意一个时刻可以有多个线程获取到锁
			B.写锁：独占锁 任意一个时刻只能有一个线程获取到锁
			C.当写线程开始工作时，限制所有读线程人堵塞
*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SafeCache {
    private ReentrantReadWriteLock reentrantReadWriteLock
            =new ReentrantReadWriteLock();
    //HashMap+ReentrantReadWriteLock 构造高效线程安全的Map
    private Map<String,Integer> map=new HashMap<>();


    public Integer getValue(String key) {
        //添加读锁。一次可有多个进行读
        reentrantReadWriteLock.readLock();
        return map.get(key);
    }

    public void setMap( String key,Integer value) {
        reentrantReadWriteLock.writeLock();
        map.put(key,value);
    }
}
