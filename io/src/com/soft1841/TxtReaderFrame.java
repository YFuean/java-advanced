package com.soft1841;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 图片阅读器窗体
 * @author yuefan
 * 2019.4.1
 */
public class TxtReaderFrame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton confirmButton;
    private JPanel topPanel;
    private JLabel[] imgLabels;
    private JPanel centerPanel;
    private Icon icon;

    public TxtReaderFrame(){
        init();
        setTitle("...");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){
        Font font = new Font("微软雅黑",1,12);
        //顶部面板
        inputField = new JTextField(50);
        inputField.setFont(font);
        inputField.setPreferredSize(new Dimension(150,40) );
        confirmButton = new JButton("确认");
        confirmButton.setFont(font);
        confirmButton.setPreferredSize(new Dimension(70,40));
        topPanel = new JPanel();
        centerPanel = new JPanel();

        topPanel.add(inputField);
        topPanel.add(confirmButton);
        //给按钮注册监听
        confirmButton.addActionListener(this);
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);

        //中间的多行文本域
        imgLabels = new JLabel[9];
    }

    public static void main(String[] args) {
        new TxtReaderFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取输入框内容
        String filePath = inputField.getText().trim();
        //创建文件
        File file = new File(filePath);

        centerPanel.setLayout(new GridLayout(3,3,10,10));

        try {
            for (int i = 0;i<9;i++){
                //使用3种方法将file中的内容读入
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                //读入内容，到字节数组
                inputStream.read(bytes);
                imgLabels[i] = new JLabel();
                icon = new ImageIcon(bytes);
                imgLabels[i].setIcon(icon);
                centerPanel.add(imgLabels[i]);
            }
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null,"io异常");
        }
    }
}
