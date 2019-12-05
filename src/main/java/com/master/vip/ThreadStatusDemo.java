package com.master.vip;

import java.util.concurrent.TimeUnit;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class ThreadStatusDemo {

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(true){
                try {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Time_Waiting_Thread").start();

        Thread t1 = new Thread(()->{
            while (!Thread.interrupted()) {
                synchronized (ThreadStatusDemo.class) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Wating_Thread");
        t1.start();

    //BLOCKED
        new Thread(new BlockedDemo(),"Blocke01_Thread").start();
        new Thread(new BlockedDemo(),"Blocke02_Thread").start();

        Thread.sleep(1000);

        t1.interrupt();
    }
    static class BlockedDemo extends  Thread{

        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
