package com.soft1841;

import javax.swing.*;
import java.awt.*;

/**
 * 设置窗体布局管理器FlowLayout布局管理器
 * @author yuefan
 * 2019.3.25
 */
public class FlowLayoutPosition extends JFrame {
    public FlowLayoutPosition(){
        //设置窗体
        setTitle("本窗体使用流式布局管理器");
        Container container = getContentPane();
        //设置窗体使用流式布局管理器，使组件右对齐，组件之间的水平间隔为10像素，垂直间隔10像素
        setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
        //在容器中循环添加10个按钮
        for (int i = 0; i<10;i++){
            container.add(new JButton("button" + i));
        }
        setSize(300,200);
        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //设置窗体可见
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutPosition();
    }
}

