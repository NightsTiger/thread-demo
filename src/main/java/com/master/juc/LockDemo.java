package com.master.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : dingwenqiang
 * @date : 2019/7/7 20:56
 */
public class LockDemo {

    private static Map<String, Object> cacheMap = new HashMap<>();
    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private static Lock read = rwl.readLock();
    private static Lock write = rwl.writeLock();

    private static Object get(String key) {
        System.out.println("开始读取数据");
        read.lock(); //读锁
        try {
            Object o = cacheMap.get(key);
            System.out.println("读到的数据：" + o.toString());
            return o;
        } finally {
            read.unlock();
        }
    }

    private static Object put(String key, Object value) {
        write.lock();
        System.out.println("开始写数据");
        try {
            return cacheMap.put(key, value);
        } finally {
            write.unlock();
        }
    }

    public static void main(String[] args) {

        new Thread(() -> put("AAA", "AAA"), "writeThread").start();

        new Thread(() -> get("AAA"), "readThread").start();

    }
}
