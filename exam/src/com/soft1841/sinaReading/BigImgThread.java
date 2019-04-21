package com.soft1841.sinaReading;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BigImgThread extends Thread {
    private String[] imgPath = {"DImg2.png","DImg2.png","DImg1.png","DImg3.png"};
    private JLabel bigImageLabel;
    public void setBigImgLabel(JLabel bigImageLabel){
        this.bigImageLabel=bigImageLabel;
    }
    public void run () {
        //循环读取图片数组
        while (true) {
            for (int i = 0; i < imgPath.length; i++) {
                //用每个资源创建一个图片对象
                Icon icon = new ImageIcon(HomePageJFrame.class.getResource("/img/" + imgPath[i]));
                bigImageLabel.setIcon(icon);
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
