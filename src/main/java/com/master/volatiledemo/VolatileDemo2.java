package com.master.volatiledemo;

/**
 * @author : dingwenqiang
 * @date : 2019/10/22 10:58
 */
public class VolatileDemo2 {

    public static void main(String[] args) {
        VolatileDemo2 demo = new VolatileDemo2();
        new Thread(demo::write).start();
        new Thread(demo::multiply).start();
    }

    private int a = 0;
    private boolean flag = false;

    private void write() {
        a = 2;              //1
        flag = true;        //2
    }


    private void multiply() {
        if (flag) {         //3
            int ret = a * a;//4
            System.out.println(ret);
        } else {
            System.out.println("我都没执行");
        }
    }

}
