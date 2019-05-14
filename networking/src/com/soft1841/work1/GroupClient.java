package com.soft1841.work1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class GroupClient extends JFrame implements ActionListener {
    private JPanel topPanel;
    private JButton sentBtn, linkBtn;
    private JTextArea jTextField;
    private Socket socket;
    public static void main (String[] args) throws IOException {
        new GroupClient();
    }
    public GroupClient () {
        init();
        setTitle("客户端");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init () {
        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(0, 0, 600, 800);
        linkBtn = new JButton("连接服务器");
        sentBtn = new JButton("发送");
// linkBtn.setPreferredSize(new Dimension(100, 25));
// sentBtn.setPreferredSize(new Dimension(100, 25));
        linkBtn.setBounds(150, 10, 100, 25);
        sentBtn.setBounds(350, 10, 100, 25);
        jTextField = new JTextArea();
        jTextField.setBounds(0, 50, 600, 700);
        topPanel.add(linkBtn);
        topPanel.add(sentBtn);
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        jTextField.setFont(font);
        add(topPanel);
        topPanel.add(jTextField);
        //连接服务器
        linkBtn.addActionListener(this);
        sentBtn.addActionListener(this);
    }
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == linkBtn) {
            try {
                socket = new Socket("10.30.144.234", 10086);
                System.out.println("成功连接上服务器");
                JOptionPane.showMessageDialog(null, "该客户端已成功连接上服务器！");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == sentBtn) {
            OutputStream outputStream = null;
            try {
                outputStream = socket.getOutputStream();
            } catch (NullPointerException ex) {
                System.out.println("失败");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            String string = jTextField.getText();
            try {
                outputStream.write(string.getBytes());
                System.out.println(string);
                outputStream.close();
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "您的消息已发送！");
        }
    }
}
