package com.master.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author : dingwenqiang
 * @date : 2019/7/21 22:24
 */
public class SemaphoreDemo {

    //限流

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            new Car(i, semaphore).start();
        }

    }

    static class Car extends Thread{
        private int i;
        private Semaphore semaphore;

        Car(int i, Semaphore semaphore) {
            this.i = i;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();

                System.out.println("占用第" + i + "个停车位");

                TimeUnit.SECONDS.sleep(2);

                semaphore.release();

                System.out.println("第" + i + "辆车开走了。");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
