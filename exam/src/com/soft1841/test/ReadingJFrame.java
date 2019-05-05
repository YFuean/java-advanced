package com.soft1841.test;

import javax.swing.*;
import java.awt.*;

public class ReadingJFrame extends JFrame {
    private JPanel panel;
    private JLabel freeBookNameLabels;
    private JTextArea freeJsTextAreas;
    private String titleString;
    private String[] strings;
    public ReadingJFrame(){
        init();
        setTitle("爬虫测试");
        //界面启动最大化
        setSize(900,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        setLayout(null);
        panel = new JPanel();
        panel.setBounds(50,10,700,500);
        panel.setBackground(Color.PINK);
        add(panel);

        GridLayout gridLayout = new GridLayout(2,4,50,30);
        panel.setLayout(gridLayout);

        ReadingJSoup readingJSoup = new ReadingJSoup();
        for (int i = 0;i<8;i++){
            freeBookNameLabels = new JLabel();
            panel.add(freeBookNameLabels);

            freeJsTextAreas = new JTextArea();
            panel.add(freeJsTextAreas);
            //readingJSoup.setFreeJsTextAreas(freeJsTextAreas);
        }
        readingJSoup.setFreeBookNameLabels(freeBookNameLabels);

    }

    public static void main(String[] args) {
        new ReadingJFrame();
    }
}
