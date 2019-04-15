package com.soft1841.exam1;

import javax.swing.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimeThread extends Thread{
    private JLabel timeLabel;

    private Thread circleThread;
    public void setCircleThread(Thread circleThread) {
        this.circleThread= circleThread;
    }

    public void setTimeLabel(JLabel timeLabel){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);
                String dateTime =  year + "-" + month + "-" + day + "  "
                        + hour + ":" + minute + ":" + second;
                timeLabel.setText(dateTime);
                //System.out.println(dateTime);
//                if (dateTime == "2019-4-15  20:38:00"){
//                    try {
//                        circleThread.join();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,0,1000);
        this.timeLabel = timeLabel;
    }
}
