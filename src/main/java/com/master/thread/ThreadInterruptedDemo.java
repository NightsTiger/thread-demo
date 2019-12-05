package com.master.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : dingwenqiang
 * @date : 2019/7/6 16:11
 */
public class ThreadInterruptedDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Before:" + Thread.currentThread().isInterrupted());
                    boolean interrupted = Thread.interrupted();
                    System.out.println("interrupted:" + interrupted);
                    System.out.println("After:" + Thread.currentThread().isInterrupted());
                }
            }
        },"interruptedThread");

        t1.start();

        TimeUnit.SECONDS.sleep(1);

        t1.interrupt();

    }
}
