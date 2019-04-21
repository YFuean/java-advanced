package com.soft1841;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * 卡片布局管理器练习
 * @author yuefan
 *2019.4.2
 */
public class CardLayoutTest extends JFrame implements ActionListener {
    private JPanel cardPanel;
    private JButton preButton,nextButton,firstButton,lastButton;
    private JPanel buttonPanel;
    private CardLayout cardLayout;

    public CardLayoutTest(){
        init();
        setTitle("卡片布局");
        setSize(1000,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){
        //创建卡片布局对象
        cardLayout = new CardLayout();
        //创建一个容器，设置成卡片布局
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        //循环调用三次，每次向容器中加入一个getPanel()方法得到的面板对象，并且编号为1，2，3
        for (int i = 0;i < 3; i++){
            cardPanel.add(String.valueOf(i + 1),getPanel());
        }
        //容器加入窗体中间
        add(cardPanel);
        //底部按钮面板，放入两个按钮面板加入底部窗体
        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(175, 177, 179));
        firstButton = new JButton("第一张");
        preButton = new JButton("上一张");
        nextButton = new JButton("下一张");
        lastButton = new JButton("最后一张");
        buttonPanel.add(firstButton);
        buttonPanel.add(preButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(lastButton);
        add(buttonPanel,BorderLayout.SOUTH);
        //按钮注册监听
        preButton.addActionListener(this);
        nextButton.addActionListener(this);
        firstButton.addActionListener(this);
        lastButton.addActionListener(this);
    }

    //构造getPanel()方法，返回一个随机背景色的JPanel对象
    private JPanel getPanel() {
        JPanel colorPanel = new JPanel();
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        colorPanel.setBackground(new Color(r,g,b));
        return colorPanel;
    }

    public static void main(String[] args) {
        new CardLayoutTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //点击的是“上一张”按钮
        if (e.getSource() == preButton){
            //调用previous显示上一张
            cardLayout.previous(cardPanel);
        }if (e.getSource() == nextButton){
            //调用next显示下一张
            cardLayout.next(cardPanel);
        }if (e.getSource() == firstButton){
            //调用第一张
            cardLayout.first(cardPanel);
        }if (e.getSource() == lastButton){
            //调用最后一张
            cardLayout.last(cardPanel);
        }
    }
}
