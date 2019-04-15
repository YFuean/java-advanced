package com.soft1841.exam1;

import javax.swing.*;
import java.awt.*;

public class ShowJFame extends JFrame {
    private JLabel timeLabel;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JLabel circleLabel;

    public ShowJFame(){
        init();
        setTitle("窗体展示");
        setSize(1500,1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        setLayout(null);
        Font font = new Font("微软雅黑",Font.PLAIN,20);
        //文本
        //创建文本区域组件，文本默认大小为20行30列
        textArea = new JTextArea(20,30);
        textArea.setSize(700,1000);
        textArea.setFont(font);
        textArea.setLineWrap(true);        //激活自动换行功能
        textArea.setWrapStyleWord(true);            // 激活断行不断字功能
        //创建滚动面板，将文本域放入滚动面板中
        scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
        //滚动面板定位
        add(scrollPane);
        scrollPane.setBounds(0,0,700,1000);
        WordThread wordThread = new WordThread();
        wordThread.setTextArea(textArea);
        wordThread.start();

        //时间
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        add(timeLabel);
        timeLabel.setBounds(800,0,300,20);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();

        //画圆
        circleLabel = new JLabel();
        add(circleLabel);
        circleLabel.setBounds(400,10,800,990);
        CircleThread circleThread = new CircleThread();
        circleThread.setCircleTread(circleLabel);
        circleThread.start();
    }

    public static void main(String[] args) {
        new ShowJFame();
    }
}
