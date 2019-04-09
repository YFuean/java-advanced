package com.soft1841.FlyPig;

import javax.swing.*;
import java.awt.*;

public class FlyPigJFrame extends JFrame {
    private JPanel bottomPanel,topPanel;
    private JLabel imgLabel;
    private JTable tableNow;

    public FlyPigJFrame(){
        init();
        setTitle("飞猪");
        //界面启动最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        //设置布局
        setLayout(null);

        //图片轮播
        imgLabel = new JLabel();
        add(imgLabel);
        imgLabel.setBounds(1200,200,340,700);
        ImgThread it=new ImgThread();
        it.setImgLabel(imgLabel);
        new Thread(it).start();

        //售票表格
        tableNow = new JTable();
        add(tableNow);
        tableNow.setBounds(300,200,340,700);
        FlyPigTicketThread tic = new FlyPigTicketThread();
        tic.setTable(tableNow);
        new Thread(tic).start();
    }

    public static void main(String[] args) {
        new FlyPigJFrame();
    }
}
