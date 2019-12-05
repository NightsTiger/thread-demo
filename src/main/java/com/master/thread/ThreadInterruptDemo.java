package com.master.thread;

/**
 * @author : dingwenqiang
 * @date : 2019/7/6 15:44
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+":我睡醒了。");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "中断了," + e);
                    //e.printStackTrace();
                }
            }
        },"interruptThread");
        t1.start();
        Thread.sleep(3000);
        t1.interrupt();
    }
}
