package com.soft1841.work1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 田震
 */
public class GroupServer extends JFrame {
    private JButton clickbutton;
    private JTextArea jTextArea;
    private JPanel jPanel;
    public GroupServer () throws IOException {
        init();
        setTitle("服务器");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init () throws IOException {
        jPanel = new JPanel();
        jPanel.setBounds(0, 0, 600, 800);
        jPanel.setLayout(null);
        add(jPanel);
        clickbutton = new JButton("服务器开启");
        clickbutton.setBounds(230, 10, 100, 25);
        Font font = new Font("微软雅黑", Font.BOLD, 12);
        clickbutton.setFont(font);
        jPanel.add(clickbutton);
        jTextArea = new JTextArea();
// jTextArea.setLineWrap(true);//激活自动换行的功能
        jTextArea.setEditable(false);
        jTextArea.setBounds(0, 50, 600, 700);
        jPanel.add(jTextArea);
        //启动监听
        clickbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerThread1 server = new ServerThread1();
                new Thread(server).start();
            }
        });
    }
    public static void main (String[] args) throws IOException {
        new GroupServer();
    }
    class ServerThread1 implements Runnable {
        private ServerSocket server;
        private Socket socket;
        public void setSocket(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                server = new ServerSocket(10086);
                JOptionPane.showMessageDialog(null, "服务器启动！");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    socket = server.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(socket.getInetAddress() + "上线了");
                InputStream in = null;
                try {
                    in = socket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] b = new byte[1024];
                try {
                    in.read(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                jTextArea.append(socket.getInetAddress()+" 发 送 的 消 息 为 ："+"\n"+new String(b)+"\n");
                        System.out.println(new String(b));
            }
        }
    }
}
