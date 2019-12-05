package com.master.chm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author : dingwenqiang
 * @date : 2019/7/27 16:21
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        Map<String, String> map = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put("name" + finalI, "value" + finalI);
            }, "thread" + i).start();
        }

        countDownLatch.countDown();

        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println(map.size());

    }

}
