package com.soft1841.countTime;

import javax.swing.*;

public class CountThread implements Runnable{
    private JLabel countLabel;
    public void setCountLabel(JLabel countLabel){
        this.countLabel = countLabel;
    }
    @Override
    public void run() {
        for (int i =10; i >= 0;i--){
            countLabel.setText(String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 0){
                JOptionPane.showMessageDialog(null, "点火");
            }
        }

    }
}
