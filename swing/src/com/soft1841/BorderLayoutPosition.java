package com.soft1841;

import javax.swing.*;
import java.awt.*;

/**
 * BorderLayoutPosition类,基础
 * @author yuefan
 *2019.3.36
 */
public class BorderLayoutPosition extends JFrame {
    public BorderLayoutPosition(){
        setTitle("这个窗体使用边界布局管理器");
        //定义一个容器
        Container container  = getContentPane();
        //设置容器为边界布局管理器
        setLayout(new BorderLayout());
        JButton centerBtn = new JButton("中"),
                northBtn = new JButton("北"),
                southBtn = new JButton("南"),
                eastBth = new JButton("东"),
                westBth = new JButton("西");
        //中部添加按钮
        container.add(centerBtn,BorderLayout.CENTER);
        container.add(northBtn,BorderLayout.NORTH);
        container.add(southBtn,BorderLayout.SOUTH);
        container.add(eastBth,BorderLayout.EAST);
        container.add(westBth,BorderLayout.WEST);
        //设置窗体大小
        setSize(350,200);
        //设置窗体可见
        setVisible(true);
        //设置关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BorderLayoutPosition();
    }
}
