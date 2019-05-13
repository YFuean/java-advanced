package com.soft1841.gui;

import javax.swing.*;

public class TencentTVFrame {
    private JPanel mainPanel;
    private JScrollPane leftScrollPane;
    private JPanel leftPanel;
    private JButton VIP会员Button;
    private JButton 电影Button;
    private JButton 综艺Button;
    private JButton 创造营2019Button;
    private JButton 少儿Button;
    private JButton 好玩Button;
    private JButton 动漫Button;
    private JButton 游戏中心Button;
    private JButton 游戏Button;
    private JButton 绝地求生Button;
    private JButton 王者荣耀Button;
    private JButton NBAButton;
    private JButton 纪录片Button;
    private JButton 今日影院Button;
    private JButton 猜你在追Button;
    private JButton 体育Button;
    private JButton 搞笑Button;
    private JButton 音乐Button;
    private JButton 汽车Button;
    private JButton 新闻Button;
    private JPanel topPanel;
    private JLabel titleLabel;
    private JTextField textField1;
    private JLabel peopleLabel;
    private JScrollPane centerScrollPanel;
    private JLabel bigLabel;
    private JLabel rightLabel;
    private JLabel c1Label;
    private JLabel c2Label;

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("TencentTVFrame");
        frame.setContentPane(new TencentTVFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1750,1030);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
