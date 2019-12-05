package com.master.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : dingwenqiang
 * @date : 2019/10/23 11:21
 */
public class ReadWriteLockDemo {

    private static Map<String, Object> cacheMap = new HashMap<>(16);

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> put(("key" + finalI), finalI)).start();
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> get(("key" + finalI))).start();
        }
    }


    private static Object get(String key) {
        try {
            readLock.lock();
            return cacheMap.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return null;
    }

    private static void put(String key, Object object) {
        try {
            writeLock.lock();
            cacheMap.put(key, object);
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
