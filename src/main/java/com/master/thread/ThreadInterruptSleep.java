package com.master.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : dingwenqiang
 * @date : 2019/7/6 17:12
 */
public class ThreadInterruptSleep {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Before:" + Thread.currentThread().isInterrupted());
            Thread.currentThread().interrupt();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("老子中断了，别睡了。");
                e.printStackTrace();
            }

            System.out.println("After:" + Thread.currentThread().isInterrupted());


        },"thread x");
        t1.start();

    }
}
