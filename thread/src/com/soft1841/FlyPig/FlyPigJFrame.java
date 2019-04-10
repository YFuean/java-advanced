package com.soft1841.FlyPig;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class FlyPigJFrame extends JFrame {
    private JPanel topPanel;
    private JLabel imgLabel,bgLabel,ticLabel;
    private JTable tableNow;

    //进度条
    private static final long serialVersionUID = 1L;
    private Thread threadA;

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
        topPanel = new JPanel();
        topPanel.setBounds(0,0,1920,1046);
        topPanel.setLayout(null);
        add(topPanel);
        topPanel.setOpaque(false);
        Font font = new Font("微软雅黑",Font.PLAIN,20);
        //标签
        ticLabel = new JLabel("5月1日G7110次列车剩余票数");
        ticLabel.setFont(font);
        topPanel.add(ticLabel);
        ticLabel.setBounds(300,100,500,30);
        //进度条
        final JProgressBar progressBar = new JProgressBar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        topPanel .add(progressBar);
        progressBar.setBounds(300,150,500,30);
        //设置进度条显示数学字符
        progressBar.setStringPainted(true);
        threadA = new Thread(new Runnable() {
            int count = 100;
            public void run() {
                while (true){
                    progressBar.setValue(--count);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        threadA.start();
        //背景图
        bgLabel = new JLabel();
        Icon backIcon = new ImageIcon(FlyPigJFrame.class.getResource("/img/bg.png"));
        bgLabel.setIcon(backIcon);
        bgLabel.setBounds(0,0,backIcon.getIconWidth(),backIcon.getIconHeight());
        add(bgLabel);

        //图片轮播
        imgLabel = new JLabel();
        topPanel.add(imgLabel);
        imgLabel.setBounds(1300,200,340,700);
        ImgThread it=new ImgThread();
        it.setImgLabel(imgLabel);
        new Thread(it).start();

        //售票表格
        // 表头（列名）
        Object[] columnNames = {"售票站点", "当前剩余票数"};
        // 表格所有行数据
        Object[][] rowData = {
                {"售票站点", "当前剩余票数"},
                {"上海虹桥站",50},
                {"上海虹桥站",49},
                {"昆山南站",48},
                {"惠山站",47},
                {"惠山站",46},
                {"惠山站",45},
                {"昆山南站",44},
                {"丹阳站",43},
                {"仙林站",42},
        };
        // 创建一个表格，指定 所有行数据 和 表头
        tableNow = new JTable(rowData, columnNames);
        tableNow.setOpaque(false);
        tableNow.setFont(font);
        tableNow.setRowHeight(30);
        topPanel.add(tableNow);
        tableNow.setBounds(300,300,340,700);
        FlyPigTicketThread tic = new FlyPigTicketThread();
        tic.setTable(tableNow);
        new Thread(tic).start();

    }

    public static void main(String[] args) {
        new FlyPigJFrame();
    }
}
