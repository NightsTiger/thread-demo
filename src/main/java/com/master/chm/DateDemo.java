package com.master.chm;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : dingwenqiang
 * @date : 2019/7/29 12:46
 */
public class DateDemo {

    public static void main(String[] args) {

        Date date = new Date();

        String ffff = getDate(date, "yyyy-MM-dd");
        Date parseDate = DateDemo.parseDate(ffff);
        System.out.println(getDate(parseDate, "yyyy-MM-dd 00:00:213"));

    }

    private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };


    private static Date parseDate(Object str) {
        if (str == null){
            return null;
        }
        try {
            return DateUtils.parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    private static String getDate(Date d, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(d);
    }
}
