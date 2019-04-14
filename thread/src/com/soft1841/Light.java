package com.soft1841;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 交通灯
 * 2019.4.15
 */
public class Light extends JFrame {
    private JPanel contentPane;
    private JLabel lblImage;

    public Light(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setContentPane(contentPane);

        JPanel imagePane = new JPanel();
        imagePane.setBackground(Color.WHITE);
        imagePane.setBorder(new TitledBorder(null, "交通灯", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(imagePane);
        imagePane.setLayout(new BorderLayout(0, 0));

        lblImage = new JLabel("");
        lblImage.setBackground(Color.WHITE);
        lblImage.setIcon(new ImageIcon(Light.class.getResource("/img/red.jpg")));
        imagePane.add(lblImage, BorderLayout.CENTER);

        DrawLight thread = new DrawLight(lblImage);
        thread.start();
    }

    public static void main(String[] args) {
        Light frame = new Light();
        frame.setVisible(true);
    }
}
class DrawLight extends Thread{
    private JLabel lblImage;

    public DrawLight(JLabel lblImage) {
        this.lblImage = lblImage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(Light.class.getResource("/img/green.jpg")));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(Light.class.getResource("/img/yellow.jpg")));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(Light.class.getResource("/img/red.jpg")));
        }

    }
}