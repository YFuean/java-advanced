package com.soft1841.exam;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class TimeThread extends Thread {
    private JLabel timeLabel;

    public TimeThread(){
        //l = now.getTime()-date.getTime();
    }

    public void setTimeLabel(JLabel timeLabel){
        this.timeLabel = timeLabel;
    }
    LocalDateTime strTime1  = LocalDateTime.of(2019,Month.APRIL,9,10,0,0);
    LocalDateTime strTime2 = LocalDateTime.now();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Date now;
    Date date;
    {
        try {
            now = df.parse(strTime2.toString());
            date = df.parse(strTime1.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    long l = now.getTime()-date.getTime();        //获取时间差
    long day=l/(24*60*60*1000);
    long hour=(l/(60*60*1000)-day*24);
    long min=((l/(60*1000))-day*24*60-hour*60);
    long s=(l/1000-day*24*60*60-hour*60*60-min*60);
    String time = ""+day+"天"+hour+"小时"+min+"分"+s+"秒";

    @Override
    public void run(){
        while (true){
            try{
                timeLabel.setText("10：00开抢"+ LocalDateTime.now());
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}
