package com.master;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

/**
 * @author : dingwenqiang
 * @date : 2019/7/12 19:27
 */
public class DecodeDemo {
    public static void main(String[] args) {

        String questionDesc = "哈哈哈";
        try {
            String decode = URLDecoder.decode(questionDesc, "UTF-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        String teaMobile = "17218988812";
//        String s = processMobile(teaMobile);
//        System.out.println("s: " + s);


        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int j = random.nextInt(2);

            System.out.println("j:" + j);
        }



    }

    /**
     * > 取后9位
     * > 第1位为0，变成1
     * @param mobile
     * @return
     */
    private static String processMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return StringUtils.EMPTY;
        }

        if (mobile.length() < 11) {
            return mobile;
        }

        //后9位
        String last9 = mobile.substring(3, 11);

        //第1位为0，变成1
        char[] chars = last9.toCharArray();
        if (last9.charAt(0) == '0') {
            chars[0] = '1';
            last9 = String.valueOf(chars);
        }

        return last9;
    }
}
