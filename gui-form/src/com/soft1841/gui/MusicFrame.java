package com.soft1841.gui;

import javax.swing.*;

public class MusicFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton 搜索Button;
    private JButton 发现Button;
    private JButton MVButton;
    private JButton 朋友Button;
    private JPanel centerPanel;
    private JLabel bottomLabel;
    private JLabel topLabel;
    private JPanel musicPanel;
    private JLabel music1;
    private JLabel music2;
    private JLabel music3;
    private JLabel music4;
    private JLabel music5;
    private JLabel music6;

    public static void main(String[] args) throws Exception{
        //根据系统设置swing外观
        String lookAndFeel=UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("MusicFrame");
        frame.setContentPane(new MusicFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1325,940);
        frame.pack();
        frame.setVisible(true);
    }
}
