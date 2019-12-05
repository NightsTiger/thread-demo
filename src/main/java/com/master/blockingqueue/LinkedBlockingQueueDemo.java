package com.master.blockingqueue;

import java.util.concurrent.*;

/**
 * @author : dingwenqiang
 * @date : 2019/8/10 16:26
 */
public class LinkedBlockingQueueDemo implements Runnable{

    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(4);
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private Integer value;

    private LinkedBlockingQueueDemo(Integer value){
        this.value = value;
    }

    public static void main(String[] args) {
        test();
    }

    private static void test(){
        for (int i = 0; i < 10; i++) {
            executorService.execute(new LinkedBlockingQueueDemo(i));
        }
        //10个线程并发put
        countDownLatch.countDown();
        executorService.shutdown();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + " into queue.put()");
            queue.put(this.value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
