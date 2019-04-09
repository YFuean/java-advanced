package com.soft1841.exam;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * 多线程练习
 * @author yuefan
 * 2019.4.8
 */
public class NumFrame extends JFrame {
    private JPanel topPanel;
    private JPanel cenPanel;
    private JPanel bottomPanel;
    private JLabel imgLabel;
    private JLabel timeLabel;
    private JLabel saleLabel;

    public NumFrame(){
        init();
        setTitle("多线程练习");
        setSize(580,1000);
        setLocationRelativeTo(null);
        //设置窗体不可变
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){
        Font saleFont = new Font("微软雅黑",Font.PLAIN,30);
        topPanel = new JPanel();
        cenPanel = new JPanel();
        bottomPanel = new JPanel();
        saleLabel = new JLabel();
        timeLabel = new JLabel("倒计时");
        imgLabel = new JLabel();
        setLayout(new GridLayout(3,1,0,5));

        add(topPanel);
        topPanel.setSize(580,500);
        add(cenPanel);
        cenPanel.setSize(580,100);
        cenPanel.setBackground(new Color(62, 134, 160));
        add(bottomPanel);
        bottomPanel.setSize(580,400);
        bottomPanel.setBackground(new Color(158, 41, 39));

        topPanel.add(imgLabel);

        timeLabel.setFont(saleFont);
        cenPanel.add(timeLabel);

        saleLabel.setFont(saleFont);
        bottomPanel.add(saleLabel);

        NumThread numThread = new NumThread();
        numThread.setSaleLabel(saleLabel);
        numThread.start();

        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();

        ImgThread imgThread = new ImgThread();
        imgThread.setImgLabel(imgLabel);
        imgThread.start();
    }

    public static void main(String[] args) {
        new NumFrame();
    }
}
