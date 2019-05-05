package com.soft1841.sinaReading;

import javax.swing.*;

/**
 * 进度条线程
 */
public class ProgressBarThread extends Thread {
    private JProgressBar progressBar;
    public void setProgressBar(JProgressBar progressBar){
        this.progressBar=progressBar;
    }
    int count = 0;
    public void run(){
        while (true){
            progressBar.setValue(++count);
            try {
                Thread.sleep(60);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
