package com.soft1841.drawLine;
/**
 * 绘图线程
 * 2019.4.10
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawLineThread implements Runnable {
    int x = 350;
    int y = 500;
    private JFrame frame;
    private Color[] colors = {Color.white,Color.blue,Color.cyan,Color.GRAY,Color.GREEN,
            Color.YELLOW,Color.RED,Color.PINK,Color.LIGHT_GRAY};

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Graphics graphics = frame.getGraphics();
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(x,y,400,y);
            y+=10;
            if (y>=500){
                y = 100;
            }
        }

    }
}
