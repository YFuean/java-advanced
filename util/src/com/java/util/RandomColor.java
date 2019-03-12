package com.java.util;

import org.omg.PortableInterceptor.INACTIVE;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

public class RandomColor {
    public static void main(String[] args) throws IOException {
        //随机种子
        Random random = new Random();
        //生成redRandom
        int redRandom = random.nextInt(256);
        //生成greenRandom
        int greenRandom = random.nextInt(256);
        //生成blueRandom
        int blueRandom = random.nextInt(256);

        System.out.println("rgb:" + redRandom+","+greenRandom+","+blueRandom);

        //生成图片
        //在图片缓冲区生成一个图片对象
        BufferedImage bufferedImage = new BufferedImage(
                120,
                40,
                4);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        //设置字体
        Font font = new Font("微软雅黑",Font.BOLD,16);
        g.setFont(font);
        //设置画笔颜色,使用随机生成的颜色
        Color color = new Color(redRandom,greenRandom,blueRandom);
        g.setColor(color);
        //开始绘制,充满图片缓冲区
        g.fillRect(0,0,120,40);
        g.setColor(Color.black);
        Random random1 = new Random();

        //输出图片
        //指定文件路径
        File file = new File("D:/rectangle.jpg");
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流写道文件
        ImageIO.write(bufferedImage,"jpg",outputStream);
        //关闭出输出流
        outputStream.close();
    }
}
