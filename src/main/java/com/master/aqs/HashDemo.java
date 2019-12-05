package com.master.aqs;

/**
 * @author : dingwenqiang
 * @date : 2019/7/23 00:08
 */
public class HashDemo {
    public static void main(String[] args) {

        HashDemo hashDemo = new HashDemo();

        System.out.println(hashDemo.hashCode());

        int h = hashDemo.hashCode();

        final int HASH_BITS = 0x7fffffff;

        // 0x7fffffff
        //   7FFFFFFF
        // 0111 1111 1111 1111 1111 1111 1111 1111 最大正整数。

        //   11101001 11101010 11101010 11101010
        //    ^
        //   00000000 00000000 11101001 11101010
        //-> 00000000 00000000 00000011 00000000

        System.out.println("HASH_BITS:" + HASH_BITS);

        int k = (h ^ (h >>> 16)) & HASH_BITS;

        System.out.println("k:" + k);

        int[] arr = new int[]{1, 2, 3};

        int[] copyArr = arr;

        arr[0] = 100;

        for (int i = 0; i < copyArr.length; i++) {
            System.out.println(copyArr[i]);

        }



    }
}
