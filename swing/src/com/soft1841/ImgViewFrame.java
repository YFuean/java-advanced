package com.soft1841;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * 使用卡片布局实现图片浏览功能
 */
public class ImgViewFrame extends JFrame implements ActionListener,MouseListener{
    private JPanel centerPanel,bottomPanel,leftPanel;
    private CardLayout cardLayout;
    private GridLayout gridLayout;
    private JButton chooseButton,preBtn,nextBtn,firstBtn,lastBtn;
    private JFileChooser fileChooser;
    private JLabel[] imgLabels;
    private JLabel newImgLabel;

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
//        preBtn = new JButton("前一张");
//        nextBtn = new JButton("后一张");
//        firstBtn = new JButton("第一张");
//        lastBtn = new JButton("最后一张");
        centerPanel = new JPanel();
        leftPanel = new JPanel();
        cardLayout = new CardLayout();
        newImgLabel = new JLabel();
        bottomPanel = new JPanel();

        centerPanel.setLayout(cardLayout);
        //centerPanel.add(imgLabel);
        add(centerPanel,BorderLayout.CENTER);
        centerPanel.setBackground(new Color(189, 230, 247));
        centerPanel.add(newImgLabel);

        leftPanel.setBackground(new Color(73, 156, 84));
        leftPanel.setMaximumSize(new Dimension(600,JFrame.HEIGHT));
        leftPanel.setMinimumSize(new Dimension(600,JFrame.HEIGHT));
        add(leftPanel,BorderLayout.WEST);

//        bottomPanel.add(firstBtn);
//        bottomPanel.add(preBtn);
        bottomPanel.add(chooseButton);
//        bottomPanel.add(nextBtn);
//        bottomPanel.add(lastBtn);
        add(bottomPanel,BorderLayout.SOUTH);
        chooseButton.addActionListener(this);
    }

    public static void main(String[] args){
        new ImgViewFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseButton){
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D:/sfood"));
            fileChooser.setMultiSelectionEnabled(true);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
                InputStream inputStream;
                byte[] bytes;
                //创建网格布局，放入leftPanel中
                gridLayout = new GridLayout((files.length / 3) + 1, 3, 5, 5);
                leftPanel.setLayout(gridLayout);
                //创建imgLabel数组
                imgLabels = new JLabel[files.length];
                for (int i = 0; i < files.length; i++) {
                    //每次循环获取一个路径，赋给files
                    files = fileChooser.getSelectedFiles();
                    //对每个子文件创建字节输出流数组,构建Icon，并设置给JLabel
                    imgLabels[i] = new JLabel();
                    try {
                        inputStream = new FileInputStream(files[i]);
                        bytes = new byte[(int) files[i].length()];
                        inputStream.read(bytes);
                        //放图片
                        Icon icon = new ImageIcon(bytes);
                        imgLabels[i].setIcon(icon);
                        leftPanel.add(imgLabels[i]);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "io异常");
                    }
                    imgLabels[i].addMouseListener(this);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //得到按下的鼠标键
        int c = e.getButton();
        //判断是鼠标左键按下
        if (c == MouseEvent.BUTTON1){
            //指定源文件   终于得到了文件路径
            File srcFile = new File(this.fileChooser.getSelectedFile().getPath());
            String src = srcFile.toString();
            System.out.println(src);
//            InputStream inputStream;
//            byte[] bytes;
//            try {
//                inputStream = new FileInputStream(srcFile);
//                bytes = new byte[(int) srcFile.length()];
//                inputStream.read(bytes);
//                //放图片
//                Icon newIcon = new ImageIcon(bytes);
//                newImgLabel.setIcon(newIcon);
//            }catch(IOException e1) {
//                e1.printStackTrace();
//            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
