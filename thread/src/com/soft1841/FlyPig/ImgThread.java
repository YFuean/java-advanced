package com.soft1841.FlyPig;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImgThread extends  Object implements Runnable {
    private  String[] imgs ={"https://upload-images.jianshu.io/upload_images/14042421-2c41286307bd45a5.png",
            "https://upload-images.jianshu.io/upload_images/14042421-6933173476215f9e.png",
            "https://upload-images.jianshu.io/upload_images/14042421-0decad68112259f2.png?imageMogr2/auto-orient/",
            "https://upload-images.jianshu.io/upload_images/14042421-57af6fe246ff2a32.png?imageMogr2/auto-orient/"};
    private JLabel imgLabel;
    public void setImgLabel(JLabel imgLabel){
        this.imgLabel=imgLabel;
    }
    @Override
    public void run () {
        int i=0;
        int length=imgs.length-1;
        while (true){
            //通过路径构造File对象
            try {
                URL url = new URL(imgs[i]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn .setRequestMethod("GET");
                conn.setConnectTimeout(5*1000);
                InputStream inStream = conn.getInputStream();
                ByteArrayOutputStream out1 = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len= 0;
                while ((len = inStream.read(buffer) ) != -1){
                    out1.write(buffer,0,len);
                }
                byte[] date = out1.toByteArray();
                inStream.read(date);
                Icon icon = new ImageIcon(date);
                imgLabel.setIcon(icon);
                Thread.sleep(1000);
                inStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IO异常");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i == length){
                i = 0;
            }
        }
    }
}

