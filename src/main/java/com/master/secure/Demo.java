package com.master.secure;

/**
 * @author : dingwenqiang
 * @date : 2019/7/6 23:38
 */
public class Demo {

    private static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(Demo::inc).start();
        }

        Thread.sleep(1000);

        System.out.println("count = " + count);
    }

    private static void inc(){
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        count++;

    }
}
