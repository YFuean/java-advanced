package com.soft1841.FlyPig;

import javax.swing.*;

public class ProgressBarThread extends Thread {
    private JProgressBar progressBar;
    public void setProgressBar(JProgressBar progressBar){
        this.progressBar=progressBar;
    }
    int count = 100;
    public void run(){
        while (true){
            progressBar.setValue(--count);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
