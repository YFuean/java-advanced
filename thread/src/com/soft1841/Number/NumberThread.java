package com.soft1841.Number;

import javax.swing.*;

/**
 * 开启一个线程显示自然数递增，用暂停和回复按钮操作本线程
 * @author yuefan
 * 2019.4.12
 */
public class NumberThread implements Runnable{
    private JLabel numLabel;

    public void setNumLabel(JLabel numLabel){
        this.numLabel = numLabel;
    }

    private final Object lock = new Object();

    private boolean pause = false;

    //调用该方法实现线程暂停
    void pauseThread(){
        pause = true;
    }

    //调用该方法实现恢复线程运行
    void resumeThread(){
        pause = false;
        synchronized (lock){
            lock.notify();
        }
    }

    //这个方法只能在run
    void onPause(){
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        int index = 0;
        while (true){
            while (pause){
                onPause();
            }
            try {
                numLabel.setText(String.valueOf(index));
                Thread.sleep(500);
                ++index;
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}
