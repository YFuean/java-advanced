package com.soft1841;

import javax.swing.*;
import java.awt.*;

public class Exam extends JFrame{
    public Exam(){
        setTitle("射雕英雄传");
        //定义一个容器
        Container container  = getContentPane();
        //设置容器为边界布局管理器
        setLayout(new BorderLayout());
        JButton centerBtn = new JButton("中神通");
        centerBtn.setBackground(Color.WHITE);
        JButton northBtn = new JButton("北丐");
        northBtn.setBackground(Color.BLACK);
        JButton southBtn = new JButton("南帝");
        southBtn.setBackground(Color.BLACK);
        JButton eastBth = new JButton("东邪");
        eastBth.setBackground(Color.BLACK);
        JButton westBth = new JButton("西毒");
        westBth.setBackground(Color.BLACK);
        //中部添加按钮
        container.add(centerBtn,BorderLayout.CENTER);
        container.add(northBtn,BorderLayout.NORTH);
        container.add(southBtn,BorderLayout.SOUTH);
        container.add(eastBth,BorderLayout.EAST);
        container.add(westBth,BorderLayout.WEST);
        //设置窗体大小
        setSize(600,400);
        //设置窗体可见
        setVisible(true);
        //设置关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Exam();
    }
}
