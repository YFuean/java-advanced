package com.soft1841;

import javax.swing.*;
import java.awt.*;

/**
 * 模仿TIM登录界面
 * @author yuefan
 * 2019.3.28
 */

public class LoginFrame extends JFrame {
    private JLabel accountLabel,passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel backgroundLabel;
    private JLabel avatarLabel;
    private JCheckBox rpJCheckBox,alJCheckBox;

    public LoginFrame(){
        init();
        setTitle("TIM LOGIN");
        setSize(644,495);
        setLocationRelativeTo(null);
        //设置窗体不可变
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        Font font = new Font("微软雅黑",Font.PLAIN,18);
        //设置字体
        accountLabel = new JLabel("注册账号");
        accountLabel.setFont(font);
        accountLabel.setForeground(new Color(39, 134, 228));
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("找回密码");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(new Color(39, 134, 228));
        passwordField = new JPasswordField();
        passwordField.setFont(font);
        rpJCheckBox = new JCheckBox("记住密码");
        rpJCheckBox.setFont(font);
        rpJCheckBox.setForeground(new Color(154, 158, 163));
        alJCheckBox = new JCheckBox("自动登录");
        alJCheckBox.setFont(font);
        alJCheckBox.setForeground(new Color(154, 158, 163));
        loginButton = new JButton("登录");
        loginButton.setFont(font);
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(0, 163, 255));

        //设置布局
        setLayout(null);
        accountField.setBounds(190,257,289,42);
        accountLabel.setBounds(493,257,76,42);
        passwordField.setBounds(190,298,289,42);
        passwordLabel.setBounds(493,298,76,42);
        rpJCheckBox.setBounds(190,345,110,30);
        alJCheckBox.setBounds(383,345,110,30);
        loginButton.setBounds(190,380,289,42);
        add(accountField);
        add(accountLabel);
        add(passwordField);
        add(passwordLabel);
        add(rpJCheckBox);
        add(alJCheckBox);
        add(loginButton);

        backgroundLabel = new JLabel();
        Icon backIcon = new ImageIcon(LoginFrame.class.getResource("/img/1.png"));
        backgroundLabel.setIcon(backIcon);
        backgroundLabel.setBounds(0,0,644,235);
        add(backgroundLabel);

        avatarLabel = new JLabel();
        Icon avatarIcon = new ImageIcon(LoginFrame.class.getResource("/img/3.png"));
        avatarLabel.setIcon(avatarIcon);
        avatarLabel.setBounds(60,245,122,122);
        add(avatarLabel);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
