package com.master.thread;

/**
 * @author : dingwenqiang
 * @date : 2019/7/6 15:44
 */
public class ThreadStatus {

    public static void main(String[] args) {

        new Thread(() -> {
            while(true){
                try {
                    synchronized (ThreadStatus.class){
                        ThreadStatus.class.wait(1000);
                        System.out.println("999");
                    }
                    //TimeUnit.SECONDS.sleep(100);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"timewaiting").start();
    }
}
