package com.soft1841;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class FileExam {
    public static void main(String[] args) throws IOException {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = year +"-"+ month +"-"+ day;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute =  calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String time = "-"+ hour + minute + second;
        //获取时间为time
        System.out.println(time);
        //获取日期为date
        System.out.println(date);
        //创建文件夹
        String path = "D:/"+ date;
        File folder = new File(path);
        if (!folder.exists()){
            folder.mkdirs();
        }
        //创建文件
        File file = new File("D:/" + date
                + "/hello" + time + ".txt");
        if (!file.exists()){
            file.createNewFile();
        }
    }
}
