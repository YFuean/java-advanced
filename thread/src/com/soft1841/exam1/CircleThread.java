package com.soft1841.exam1;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CircleThread extends Thread{
    int x = 900;
    int y = 700;
    private JLabel circleLabel;

    public void setCircleTread(JLabel circleLabel) {
        this.circleLabel = circleLabel;
    }

    @Override
    public void run() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 1; i  <= 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Graphics graphics = circleLabel.getGraphics();
                    graphics.setColor(Color.BLACK);
                    //控制圆心的位置，和半径
                    graphics.drawOval(x / 2 - (i + 1) * 10, y / 2 - (i + 1) * 10, 10 + 20 * i, 10 + 20 * i);
                }
            }
        };
        java.util.Timer timer = new Timer();
        timer.schedule(timerTask,5,1000);
    }
}
