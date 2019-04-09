package com.soft1841.ImgLook;

import javax.swing.*;
import java.awt.*;

public class CarouselJFrame extends JFrame {
    private JLabel bgLabel;

    public CarouselJFrame(){
        init();
        setTitle("轮播");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        bgLabel  = new JLabel();
        add(bgLabel);
        CarouselThread ct = new CarouselThread();
        ct.setBgLabel(bgLabel);
        new Thread(ct).start();
    }

    public static void main(String[] args) {
        new CarouselJFrame();
    }
}
