package com.java.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

public class RandomColor {
    public static void main (String[] args) throws IOException {
        Random random=new Random();
        int redRandom=random.nextInt(256);
        int greenRandom=random.nextInt(256);
        int blueRandom=random.nextInt(256);
        String randomcode = "";
        String model = "1234567890"+"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz";
        char[] m = model.toCharArray();
        for (int j = 0; j < 4; j++) {
            char c = m[(int) (Math.random() * 54)];
            // 保证四位随机数之间没有重复的
            if (randomcode.contains(String.valueOf(c))) {
                j--;
                continue;
            }
            randomcode = randomcode + c;
        }
        System.out.println("R:"+redRandom+",G:"+greenRandom+",B:"+blueRandom);
        System.out.println(randomcode);
        //开始用随机数绘制图片
        //生成在图片缓冲区生成一个图片对象，指定图片大小和类型
        BufferedImage bufferedImage=new BufferedImage(150,60,BufferedImage.TYPE_INT_BGR);
        //获取画笔
        Graphics g=bufferedImage.getGraphics();
        //设置字体
        Font font=new Font("微软雅黑",Font.BOLD,20);
        g.setFont(font);
        //设置画笔颜色
        Color color=new Color(redRandom,greenRandom,blueRandom);
        g.setColor(color);
        //绘制,充满图片缓冲区
        g.setColor(Color.WHITE);
        g.drawString(randomcode,40,15);
        g.setColor(Color.getColor(null));
        for (int i=0;i<20;i++){
            Color color2=new Color(random.nextInt(256),
                    random.nextInt(256),random.nextInt(256));
            g.setColor(color2);
            int x = random.nextInt(150);
            int y = random.nextInt(60);
            int xl = random.nextInt(150);
            int yl = random.nextInt(60);
            g.drawLine(x,y,x+xl,y+yl);
        }

        //绘制文字
        g.setColor(Color.black);
        g.drawString(randomcode,40,25);
        //要输出图片
        //指定文件，获取输出流
        File file=new File("D:/code.jpg");
        //获取字节输出流
        OutputStream outputStream=new FileOutputStream(file);
        //将图片从缓冲区通过字节流写到文件
        ImageIO.write(bufferedImage,"jpg",outputStream);
        //及时关闭这个输出流
        outputStream.close();
    }
}