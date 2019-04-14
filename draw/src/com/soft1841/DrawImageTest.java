package com.soft1841;

import javax.swing.*;
import java.awt.*;

/**
 * 在窗体中绘制图像
 * 2019.4.11
 */
public class DrawImageTest extends JFrame {
    public DrawImageTest(){
        this.setSize(480,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体为绘图面板对象
        add(new CanvasTest());
        this.setTitle("绘制图像");
    }

    //创建画布
    class CanvasTest extends Canvas{
        public void paint(Graphics g){
            super.paint(g);
            //创建绘画对象
            Graphics2D g2 = (Graphics2D) g;
            //获取图片资源
            Image image = new ImageIcon(this.getClass().getResource("/img/gallery3.jpg")).getImage();
            //显示图像
            g2.drawImage(image,0,0,this);
        }
    }

    public static void main(String[] args) {
        new DrawImageTest().setVisible(true);
    }
}
