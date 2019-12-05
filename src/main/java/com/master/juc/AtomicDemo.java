package com.master.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicDemo {

    // volatile 只保证可见性，并不保证线程安全。
    // 可见性 -> 线程在cpu0做过i++，之后，可能也会被其他cpu执行完刷新到主内存的i给覆盖。
    // 非原子操作需要加lock
    private static volatile int count = 0;
    private static Lock lock = new ReentrantLock();

    private static void inc() {
//        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
//        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicDemo::inc).start();
        }
        Thread.sleep(1000);

        System.out.println("result:" + count);
    }
}