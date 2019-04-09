package com.soft1841.exam;

import javax.swing.*;
import java.util.Random;

/**
 * 多线程练习
 * @author yuefan
 * 2019.4.8
 */
public class NumThread extends Thread{
    private JLabel saleLabel;
    private int saleNumber = 500;

    public void setSaleLabel(JLabel saleLabel){
        this.saleLabel = saleLabel;
    }

    @Override
    public void run(){
        while (true){
            try {
                if (++saleNumber== 900){
                    break;
                }
                saleLabel.setText("月销"+saleNumber);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
