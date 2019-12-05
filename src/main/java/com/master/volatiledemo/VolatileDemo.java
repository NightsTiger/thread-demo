package com.master.volatiledemo;

/**
 * @author : dingwenqiang
 * @date : 2019/7/7 18:02
 * @description : 指令重排序问题
 */
public class VolatileDemo {

    private static volatile int value = 3;
    private static volatile boolean isFinish = false;

    public static void main(String[] args) {
        etxToCpu0();
        etxToCpu1();
    }

    private static void etxToCpu0() {
        value = 10;
        // 写入到store buffer ，通知cpu1失效，并且异步等待ack

        // 先执行 //加入isFinish 在cpu0中是E状态，会直接修改
        isFinish = true;
    }

    private static void etxToCpu1() {
        // 从主内存中读取数据
        if (isFinish) {
            // 此时value并没有被cpu0刷新到主内存，就被cpu直接读取了
            System.out.println(value == 10);
        }
    }


}
