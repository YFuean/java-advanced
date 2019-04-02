package com.soft1841;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 使用卡片布局实现图片浏览功能
 */
public class ImgViewFrame extends JFrame implements ActionListener {
    private JPanel centerPanel,bottomPanel,leftPanel;
    private JScrollPane scrollPane;
    private CardLayout cardLayout;
    private ScrollPaneLayout scrollPaneLayout;
    private GridLayout gridLayout;
    private JButton chooseButton,preBtn,nextBtn,firstBtn,lastBtn;
    private JFileChooser fileChooser;
    private JLabel[] imgLabels;

    public ImgViewFrame(){
        init();
        setTitle("卡片布局浏览图片");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        chooseButton = new JButton("选择");
        preBtn = new JButton("前一张");
        nextBtn = new JButton("后一张");
        firstBtn = new JButton("第一张");
        lastBtn = new JButton("最后一张");
        centerPanel = new JPanel();
        leftPanel = new JPanel();
        scrollPane = new JScrollPane();
        cardLayout = new CardLayout();
        scrollPaneLayout = new ScrollPaneLayout();

        bottomPanel = new JPanel();
        centerPanel.add(chooseButton);
        centerPanel.setLayout(cardLayout);
        add(centerPanel,BorderLayout.CENTER);
        leftPanel.setBackground(new Color(73, 156, 84));
        leftPanel.setMaximumSize(new Dimension(600,JFrame.HEIGHT));
        leftPanel.setMinimumSize(new Dimension(600,JFrame.HEIGHT));
        add(scrollPane,BorderLayout.WEST);
        scrollPane.setLayout(scrollPaneLayout);
        scrollPane.add(leftPanel);

        bottomPanel.add(firstBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(chooseButton);
        bottomPanel.add(nextBtn);
        bottomPanel.add(lastBtn);
        chooseButton.addActionListener(this);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        firstBtn.addActionListener(this);
        lastBtn.addActionListener(this);
        add(bottomPanel,BorderLayout.SOUTH);
    }

    public static void main(String[] args){
        new ImgViewFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseButton){
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D:/avatar"));
            fileChooser.setMultiSelectionEnabled(true);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File[] files = fileChooser.getSelectedFiles();
                InputStream inputStream;
                byte[] bytes;

                //创建网格布局，放入leftPanel中
                gridLayout = new GridLayout((files.length/3)+1,3,5,5);
                leftPanel.setLayout(gridLayout);
                //创建imgLabel数组
                imgLabels = new JLabel[files.length];
                for (int i = 0 ; i < files.length; i++){
                    //对每个子文件创建字节输出流数组,构建Icon，并设置给JLabel
                    imgLabels[i] = new JLabel();
                    for (File file:files) {
                        try {

                            inputStream = new FileInputStream(file);
                            bytes = new byte[(int) file.length()];
                            inputStream.read(bytes);
                            //
                            Icon icon = new ImageIcon(bytes);
                            imgLabels[i].setIcon(icon);
                            leftPanel.add(imgLabels[i]);

                        } catch (IOException e1) {
                            JOptionPane.showMessageDialog(null, "io异常");
                        }
                    }
                    //


                }
        }
        }if (e.getSource() == preBtn){
            cardLayout.previous(centerPanel);
        }if (e.getSource() == nextBtn){
            cardLayout.next(centerPanel);
        }if (e.getSource() == firstBtn){
            cardLayout.first(centerPanel);
        }if (e.getSource() == lastBtn){
            cardLayout.last(centerPanel);
        }

    }
}
