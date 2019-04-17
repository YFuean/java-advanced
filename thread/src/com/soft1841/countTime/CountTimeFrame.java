package com.soft1841.countTime;

import com.soft1841.FlyPig.FlyPigJFrame;
import com.soft1841.exam1.CircleThread;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * 倒计时器
 * 2019.4.17
 */
public class CountTimeFrame extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton actionButton;
    private JLabel countLabel;

    private CountTimeFrame(){
        init();
        setTitle("倒计时器");
        setSize(500,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        Font font = new Font("微软雅黑", Font.BOLD,20);
        Font font1 = new Font("微软雅黑",Font.BOLD,50);
        //创建timeLabel对象的同时，将背景图绘制上去，
        panel = new JPanel(){
            protected void paintComponent(Graphics g){
                try{
                    Image bg = ImageIO.read(new File("D:/JavaStudy/java-advanced/thread/src/img/FreshB6.jpg"));
                    g.drawImage(bg,0,0,getWidth(),getHeight(),null);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };
        add(panel);
        panel.setLayout(null);
        panel.setOpaque(false);

        actionButton = new JButton(){

            protected void paintComponent(Graphics g){
                try{
                    //获取图片并绘制在当前对象上
                    Image bg = ImageIO.read(new File("D:/JavaStudy/java-advanced/thread/src/img/border5.png"));
                    g.drawImage(bg,0,0,getWidth(),getHeight(),null);
                    g.drawString("开始",77,33);
                    g.setFont(font);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };
        //背景透明
        actionButton.setContentAreaFilled(false);
        actionButton.setFont(font);
        actionButton.setBounds(140,100,200,50);
        actionButton.addActionListener(this);
        panel.add(actionButton);


        countLabel = new JLabel();
        countLabel.setBounds(220,300,300,100);
        countLabel.setFont(font1);
        panel.add(countLabel);
    }

    public static void main(String[] args) {
        new CountTimeFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == actionButton){
            CountThread countThread = new CountThread();
            countThread.setCountLabel(countLabel);
            Thread thread = new Thread(countThread);
            thread.start();
        }
    }
}
