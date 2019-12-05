package com.master.deadlock;

/**
 * @author : dingwenqiang
 * @date : 2019/10/23 11:09
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        DeadLockDemo dd = new DeadLockDemo();
        dd.demo();
    }

    private synchronized void demo(){
        System.out.println("demo");
        demo2();
    }

    private void demo2(){
        System.out.println("demo2");
        synchronized (this){
            System.out.println("demo2 synchronized");
        }
    }
}
