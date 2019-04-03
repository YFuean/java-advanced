package com.soft1841;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 图片窗体程序
 * @author yuefan
 * 2019.3.26
 */
public class ImageFrame extends JFrame {
    private JPanel topPanel;
    private JButton[] buttons;
    private JLabel imgLabel;
    private Icon icon;
    private JLabel nameLabel;
    private JLabel timeLabel;

    public ImageFrame(){
        init();
        setTitle("图片窗体");
        setSize(1000,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //设置布局，放置组件
    public void init(){
        topPanel = new JPanel();
        buttons = new JButton[5];
        for (int i = 0 ; i < 5 ; i++){
            buttons[i] = new JButton("按钮" + i + 1);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        imgLabel = new JLabel();




        //读入本地图片到到内存的字节数组
        File srcFile = new File("D:/blue.jpg");
        InputStream inputStream;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(srcFile);
            bytes = new byte[(int) srcFile.length()];
            inputStream.read(bytes);
        } catch (IOException e) {
            System.out.println("io异常");
        }
        //获取时间
        LocalDateTime now = LocalDateTime.now();
        timeLabel = new JLabel(String.valueOf(now));
        add(timeLabel,BorderLayout.EAST);
        //获取路径
        String name = srcFile.getPath();
        nameLabel = new JLabel(name);
        add(nameLabel,BorderLayout.SOUTH);
        //放图片
        icon = new ImageIcon(bytes);
        imgLabel.setIcon(icon);
        add(imgLabel,BorderLayout.CENTER);
        
    }
    public static void main(String[] args) {
        new ImageFrame();
    }
}
