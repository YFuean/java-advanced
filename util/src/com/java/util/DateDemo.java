package com.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 最常用格式化日期
 */
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时计时法
        SimpleDateFormat f2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时计时法
        System.out.println(f1.format(date));
        System.out.println(f2.format(date));
    }
}
