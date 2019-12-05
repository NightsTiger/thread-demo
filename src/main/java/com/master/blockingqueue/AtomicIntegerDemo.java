package com.master.blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : dingwenqiang
 * @date : 2019/8/10 15:50
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i = 0; i < 1000; i++) {
            int andIncrement = atomicInteger.getAndIncrement();
            System.out.println(andIncrement);
        }

        System.out.println("加完1000次之后:" + atomicInteger);

        System.out.println("------------------------------------------------------------");

        int addAndGet = atomicInteger.addAndGet(1);

        System.out.println("addAndGet:" + addAndGet);

        System.out.println(atomicInteger.get());

    }
}
