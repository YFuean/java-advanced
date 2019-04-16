package com.soft1841.clock;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 闹钟
 * 2019.4.16
 */
public class TimeFrame extends JFrame {
    private TimerTask clockTask;
    private Timer timer;
    private JLabel timeLabel;
    private JPanel jPanel;
    public TimeFrame() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Time定时器练习");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(1500,780);
    }
    private void init() throws IOException {
        Font font = new Font("微软雅黑", Font.BOLD, 24);
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        timeLabel.setOpaque(false);
        clockTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(date);
                timeLabel.setText(timeString);
                if(timeString.equals("2019-04-16 09:01:40")){
                    JOptionPane.showMessageDialog(jPanel, "9：01了！！！");
                }
                if (timeString.equals("2019-04-16 09:02:00")){
                    JOptionPane.showMessageDialog(jPanel, "时间到~~");
                    this.cancel();
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(clockTask, 0, 1000);
        //创建timeLabel对象的同时，将背景图绘制上去，
         jPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                try{
                    Image bg = ImageIO.read(new File("D:/bg4.jpg"));
                    g.drawImage(bg,0,0,getWidth(),getHeight(),null);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
         };
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,100));
        add(jPanel);
        jPanel.add(timeLabel);
    }
    public static void main(String[] args) {
        new TimeFrame();
    }
}
