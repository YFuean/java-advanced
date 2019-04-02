package com.soft1841;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class JFileChooserTest extends JFrame implements ActionListener {
    private JButton chooseButton;
    private JLabel pathLabel;
    private JFileChooser fileChooser;

    public JFileChooserTest(){
        init();
        setTitle("JFileChooser");
        setSize(1000,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        chooseButton = new JButton("选择文件");
        pathLabel = new JLabel("暂无选择");
        add(chooseButton, BorderLayout.NORTH);
        chooseButton.addActionListener(this);
        Font font = new Font("微软雅黑",Font.PLAIN,26);
        pathLabel.setFont(font);
        add(pathLabel,BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new JFileChooserTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //创建FileChooser对象
        fileChooser = new JFileChooser();
        //设置文件选择器的默认路径
        fileChooser.setCurrentDirectory(new File("D:/"));
        //打开对话框
        int result = fileChooser.showOpenDialog(null);
        //用户点击了“确认”按钮
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();

            try {
                InputStream inputStream = new FileInputStream(file);

            } catch (FileNotFoundException e1) {

            }
        }
    }
}
