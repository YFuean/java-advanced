package com.soft1841.ImgLook;

import javax.swing.*;
import java.io.*;

public class CarouselThread implements Runnable {
    private String[] imgs= {"D:/bg/bgblack3.jpg","D:/bg/bgblack4.jpg","D:/bg/bgwhite.jpg"};
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel){
        this.bgLabel = bgLabel;
    }
    @Override
    public void run() {
        int i = 0;
        int len = imgs.length - 1;
        while (true){
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                Thread.sleep(2000);
                i++;
                if (i== len){
                    i = 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
