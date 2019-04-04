package com.soft1841;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * 图片浏览功能
 * @author yuefan
 * 2019.4.4
 */
public class ImgViewFrame extends JFrame implements ActionListener{
    private JPanel centerPanel,bottomPanel,leftPanel,panel;
    private CardLayout cardLayout;
    private GridLayout gridLayout;
    private JButton chooseButton;
    private JFileChooser fileChooser;
    private JLabel[] imgLabels;
    private JLabel newImgLabel;

    public ImgViewFrame(){
        init();
        setTitle("浏览图片");
        setSize(1300,900);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        chooseButton = new JButton("选择");
        //copyButton = new JButton("备份");
        centerPanel = new JPanel();
        leftPanel = new JPanel();
        cardLayout = new CardLayout();
        newImgLabel = new JLabel();
        bottomPanel = new JPanel();
        panel = new JPanel();

        centerPanel.setLayout(cardLayout);
        add(centerPanel,BorderLayout.CENTER);
        centerPanel.setBackground(new Color(189, 230, 247));
        centerPanel.add(newImgLabel);

        panel.setBackground(new Color(73, 156, 84));
        leftPanel.setBackground(new Color(73, 156, 84));
        panel.setMaximumSize(new Dimension(600,JFrame.HEIGHT));
        panel.setMinimumSize(new Dimension(600,JFrame.HEIGHT));
        chooseButton.setSize(new Dimension(600,20));
        panel.setSize(new Dimension(600,JFrame.HEIGHT));
        panel.add(chooseButton);
        panel.add(leftPanel);
        add(panel,BorderLayout.WEST);

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
                gridLayout = new GridLayout((files.length / 3) + 1, 3, 10, 5);
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
                    imgLabels[i].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            //得到按下的鼠标键
                            int c = e.getButton();
                            //判断是鼠标左键按下
                            if (c == MouseEvent.BUTTON1){
                                //指定源文件   终于得到了文件路径
                                File srcFile = new File(fileChooser.getSelectedFile().getPath());
                                String src = srcFile.toString();
                                System.out.println(src);
                                InputStream inputStream;
                                byte[] bytes;
                                try {
                                    inputStream = new FileInputStream(srcFile);
                                    bytes = new byte[(int) srcFile.length()];
                                    inputStream.read(bytes);
                                    //放图片
                                    Icon newIcon = new ImageIcon(bytes);
                                    newImgLabel.setIcon(newIcon);
                                }catch(IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
