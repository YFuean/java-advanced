package com.soft1841.exam;

import javafx.application.Platform;

import javax.swing.*;

public class ImgThread extends Thread {
    private JLabel imgLabel;
    String[] imgPath = {"gallery2.jpg", "gallery3.jpg", "gallery5.jpg", "gallery6.jpg"};

    public void setImgLabel(JLabel imgLabel) {
        this.imgLabel = imgLabel;
    }

    public void run() {
        //循环读取图片数组
        while (true) {
            for (int i = 0; i < imgPath.length; i++) {
                //用每个资源创建一个图片对象
                Icon icon = new ImageIcon(NumFrame.class.getResource("/img/" + imgPath[i]));
                imgLabel.setIcon(icon);
                try {
                    //休眠2秒
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //轮播到最后一张图的时候，回到第一张重新播放
                if (i == imgPath.length - 1) {
                    i = 0;
                }
            }
        }
    }
}
