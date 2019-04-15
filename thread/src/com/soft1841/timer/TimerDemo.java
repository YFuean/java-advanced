package com.soft1841.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        };

        Timer timer = new Timer();
        timer.schedule(task,0,500);
        timer.schedule(task2,0,1000);
    }
}
