package com.master.volatiledemo;

/**
 * @author : dingwenqiang
 * @date : 2019/10/22 11:13
 * volatile 并不保证原子性
 * @see <link>https://juejin.im/post/5a2b53b7f265da432a7b821c</link>
 */
public class AtomicTest {
    private volatile int inc = 0;

    private void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final AtomicTest test = new AtomicTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    test.increase();
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(test.inc);
    }
}

