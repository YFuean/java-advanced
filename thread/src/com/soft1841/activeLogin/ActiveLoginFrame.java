package com.soft1841.activeLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ActiveLoginFrame extends JFrame implements ActionListener {
    private int width;
    private int height;
    private JLabel accountLabel,passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel avatarLabel;
    private JCheckBox rpJCheckBox,alJCheckBox;

    public ActiveLoginFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setTitle("吃葡萄不吐葡萄皮");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    class ShadePanel extends JPanel  {
        public  ShadePanel(){
            java.util.Timer timer = new Timer();
            timer.schedule(timerTask,0,1000);
        }
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        };
        @Override
        protected void paintComponent(Graphics g1) {
            Graphics2D g = (Graphics2D) g1;
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();
            Color[] color = {Color.CYAN,Color.MAGENTA,Color.BLUE,Color.PINK,Color.GREEN,Color.GRAY};
            Random r = new Random();
            int i = r.nextInt(6);
            int j = r.nextInt(6);
            //创建填充模式对象
            GradientPaint paint = new GradientPaint(i, j, color[i], 0, height,color[j]);
            g.setPaint(paint);
            g.fillRect(i, j, width, height);
        }
    }

    class LoginPane extends JPanel{
        private float transparency =.1f;
        public LoginPane(){
        }
        /**这个方法用来设置JPanel的透明度
         *
         * @param transparency:透明度
         *
         * @return void
         */
        public void setTransparent(float transparency) {
            this.transparency = transparency;
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D graphics2d = (Graphics2D) g.create();
            graphics2d.setComposite(AlphaComposite.SrcOver.derive(transparency));
            graphics2d.setColor(getBackground());
            graphics2d.fillRect(0, 0, getWidth(), getHeight());
            graphics2d.dispose();
        }
    }
    private void init() {
        setLayout(null);
        ShadePanel shadePanel = new ShadePanel();
        shadePanel.setLayout(null);
        shadePanel.setBounds(0, 0, width, height);
        LoginPane loginPanel = new LoginPane();
        loginPanel.setBackground(new Color(234,241,248));
        loginPanel.setLayout(null);
        loginPanel.setTransparent(0.8f);
        loginPanel.setBounds(620, 280, 580, 450);
        shadePanel.add(loginPanel);
        add(shadePanel);
        Font font = new Font("微软雅黑", Font.PLAIN, 18);
        //设置字体
        accountLabel = new JLabel("注册账号");
        accountLabel.setFont(font);
        accountLabel.setForeground(new Color(39, 134, 228));
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("找回密码");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(new Color(39, 134, 228));
        passwordField = new JPasswordField();
        passwordField.setFont(font);
        rpJCheckBox = new JCheckBox("记住密码");
        rpJCheckBox.setFont(font);
        rpJCheckBox.setForeground(new Color(154, 158, 163));
        alJCheckBox = new JCheckBox("自动登录");
        alJCheckBox.setFont(font);
        alJCheckBox.setForeground(new Color(154, 158, 163));
        loginButton = new JButton("登录");
        loginButton.addActionListener(this);
        loginButton.setFont(font);
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(0, 163, 255));
        //设置布局
        setLayout(null);
        accountField.setBounds(100, 257, 289, 42);
        accountLabel.setBounds(403, 257, 76, 42);
        passwordField.setBounds(100, 300, 289, 42);
        passwordLabel.setBounds(403, 300, 76, 42);
        rpJCheckBox.setBounds(100, 345, 110, 30);
        alJCheckBox.setBounds(293, 345, 110, 30);
        loginButton.setBounds(100, 380, 289, 42);
        loginPanel.add(accountField);
        loginPanel.add(accountLabel);
        loginPanel.add(passwordField);
        loginPanel.add(passwordLabel);
        loginPanel.add(rpJCheckBox);
        loginPanel.add(alJCheckBox);
        loginPanel.add(loginButton);

        avatarLabel = new JLabel();
        Icon avatarIcon = new ImageIcon(ActiveLoginFrame.class.getResource("/img/3.png"));
        avatarLabel.setIcon(avatarIcon);
        avatarLabel.setBounds(200,30,122,122);
        loginPanel.add(avatarLabel);
        loginPanel.add(alJCheckBox);
    }
    public static void main (String[] args) {
        new ActiveLoginFrame();
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        JOptionPane.showMessageDialog(null, "登录成功");
    }
}
