package com.soft1841.sinaReading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 大作业，模仿新浪读书，综合运用线程，IO，爬虫，集合，窗体等
 * @author yuefan
 */
public class HomePageJFrame extends JFrame implements ActionListener{
    private JPanel topPanel,topPanel1,topPanel2,smallTopPanel;
    private JPanel centerPanel,firstPanel,hotPanel,boyPanel,newBookPanel,freePanel;
    private JLabel logoImgLabel,loginImgLabel,phoneImgLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton homeButton,hotButton,boyButton,girlButton,newBookButton,freeBookButton;
    private CardLayout bookCardLayout,cardLayout;
    private JPanel bottomPanel,smallBottomPanel,bookPanel;
    private JLabel fgImgLabel,freeLabel,bookLabel1,bookLabel2,bookLabel3,timeLabel;
    private JButton previousButton,nextButton;
    private JLabel bigImageLabel,smallFgImgLabel;
    private JPanel gridPanel,boxPanel1,boxPanel2;
    private JPanel newBookPanels;
    private JLabel coverLabels,nameLabels,writerLabels;
    private JTextArea jsTextAreas;
    private JTable boyTable,girlTabel;
    public HomePageJFrame(){
        init();
        setTitle("新浪读书");
        //界面启动最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        Font font1 = new Font("微软雅黑",Font.PLAIN,20);
        Font font2 = new Font("微软雅黑",Font.PLAIN,18);
        Font font3 = new Font("微软雅黑",Font.BOLD,18);
        Font font4 = new Font("微软雅黑",Font.BOLD,24);
        Font font5 = new Font("微软雅黑",Font.BOLD,36);

        setLayout(new BorderLayout(0,0));
        //顶部面板topPanel中包括topPanel1和topPanel2
        topPanel = new JPanel();
        add(topPanel,BorderLayout.NORTH);
        BoxLayout boxLayout = new BoxLayout(topPanel,BoxLayout.Y_AXIS);
        topPanel.setLayout(boxLayout);
        topPanel.setPreferredSize(new Dimension(getWidth(),180));
        topPanel.setBackground(Color.WHITE);
        //在topPanel1中，topPanel1设置水平box
        topPanel1 = new JPanel();
        topPanel.add(topPanel1);
        BoxLayout boxLayout1 = new BoxLayout(topPanel1,BoxLayout.X_AXIS);
        topPanel1.setLayout(boxLayout1);
        topPanel1.setPreferredSize(new Dimension(getWidth(),100));
        topPanel1.setBackground(Color.WHITE);

        logoImgLabel = new JLabel();
        Icon logoIcon = new ImageIcon(HomePageJFrame.class.getResource("/img/logo.png"));
        logoImgLabel.setIcon(logoIcon);
        logoImgLabel.setPreferredSize(new Dimension(400,200));
        topPanel1.add(logoImgLabel);
        //将searchField，searchButton包在smallTopPanel里，smallTopPanel自动自动填充topPanel
        smallTopPanel = new JPanel();
        smallTopPanel.setLayout(null);
        smallTopPanel.setBackground(Color.WHITE);
        topPanel1.add(smallTopPanel);
        searchField = new JTextField("搜索书名作者");
        searchField.setFont(font1);
        searchField.setForeground(new Color(117,117,117));
        searchField.setBounds(300,30,400,50);
        //设置边框线，颜色，粗细5，圆角true
        searchField.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),3,true));
        smallTopPanel.add(searchField);

        searchButton = new JButton("search");
        searchButton.setFont(font3);
        searchButton.setBackground(new Color(130, 15, 40));
        searchButton.setForeground(new Color(255, 255, 255));
        searchButton.setPreferredSize(new Dimension(90,60));
        searchButton.setBounds(700,30,110,50);
        smallTopPanel.add(searchButton);

        loginImgLabel = new JLabel();
        Icon loginIcon = new ImageIcon(HomePageJFrame.class.getResource("/img/login.png"));
        loginImgLabel.setIcon(loginIcon);
        loginImgLabel.setPreferredSize(new Dimension(400,200));
        topPanel1.add(loginImgLabel);

        //在topPanel2中，topPanel2设置空布局
        topPanel2 = new JPanel();
        topPanel.add(topPanel2);
        topPanel2.setLayout(null);
        topPanel2.setPreferredSize(new Dimension(getWidth(),80));
        topPanel2.setBackground(new Color(130, 15, 40));

        homeButton = new JButton("首页");
        topPanel2.add(homeButton);
        homeButton.setFont(font4);
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(new Color(130, 15, 40));
        homeButton.setBounds(30,0,100,80);
        homeButton.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),3));
        homeButton.addActionListener(this);
        hotButton = new JButton("最火");
        topPanel2.add(hotButton);
        hotButton.setFont(font4);
        hotButton.setForeground(Color.WHITE);
        hotButton.setBackground(new Color(130, 15, 40));
        hotButton.setBounds(130,0,100,80);
        hotButton.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),3));
        hotButton.addActionListener(this);
        boyButton = new JButton("男生");
        topPanel2.add(boyButton);
        boyButton.setFont(font4);
        boyButton.setForeground(Color.WHITE);
        boyButton.setBackground(new Color(130, 15, 40));
        boyButton.setBounds(230,0,100,80);
        boyButton.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),3));
        boyButton.addActionListener(this);
        girlButton = new JButton("女生");
        topPanel2.add(girlButton);
        girlButton.setFont(font4);
        girlButton.setForeground(Color.WHITE);
        girlButton.setBackground(new Color(130, 15, 40));
        girlButton.setBounds(330,0,100,80);
        girlButton.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),3));
        girlButton.addActionListener(this);
        newBookButton = new JButton("最新");
        topPanel2.add(newBookButton);
        newBookButton.setFont(font4);
        newBookButton.setForeground(Color.WHITE);
        newBookButton.setBackground(new Color(130, 15, 40));
        newBookButton.setBounds(430,0,100,80);
        newBookButton.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),3));
        newBookButton.addActionListener(this);
        freeBookButton = new JButton("免费");
        topPanel2.add(freeBookButton);
        freeBookButton.setFont(font4);
        freeBookButton.setForeground(Color.WHITE);
        freeBookButton.setBackground(new Color(130, 15, 40));
        freeBookButton.setBounds(530,0,100,80);
        freeBookButton.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),3));
        freeBookButton.addActionListener(this);
        phoneImgLabel = new JLabel();
        Icon phoneIcon = new ImageIcon(HomePageJFrame.class.getResource("/img/phone.png"));
        phoneImgLabel.setIcon(phoneIcon);
        phoneImgLabel.setBounds(1350,0,480,80);
        topPanel2.add(phoneImgLabel);
        //中间面板
        centerPanel = new JPanel();
        add(centerPanel,BorderLayout.CENTER);
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setPreferredSize(new Dimension(getWidth(),540));
        //首页面板
        firstPanel = new JPanel();
        firstPanel.setBackground(Color.WHITE);
        centerPanel.add("1",firstPanel);
        cardLayout.show(centerPanel,"1");//设置默认面板
        firstPanel.setLayout(null);
        bigImageLabel = new JLabel();  //轮播图
        firstPanel.add(bigImageLabel);
        bigImageLabel.setBounds(27,23,1300,500);
        BigImgThread bigImgThread = new BigImgThread();
        bigImgThread.setBigImgLabel(bigImageLabel);
        bigImgThread.start();
        gridPanel = new JPanel();//网格按钮
        gridPanel.setLayout(new GridLayout(3,3,30,20));
        for (int i = 0;i<9;i++) {
            JButton button = new JButton();
            String[] strings = {"都市校园","玄幻奇幻","武侠仙侠",
                    "悬疑灵异","军事历史","穿越重生",
                    "古风古韵","豪门总裁","幻想言情"};
            button.setText(strings[i]);
            gridPanel.add(button);
            button.setFont(font1);
            button.setForeground(new Color(154, 154, 154));
            button.setBackground(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),3,true));
        }
        gridPanel.setBounds(1380,30,480,200);
        gridPanel.setBackground(Color.WHITE);
        firstPanel.add(gridPanel);
        gridPanel = new JPanel();
        //垂直盒子文字
        boxPanel1 = new JPanel();
        BoxLayout word1BoxLayout = new BoxLayout(boxPanel1,BoxLayout.Y_AXIS);
        boxPanel1.setLayout(word1BoxLayout);
        for (int i = 0;i<7;i++){
            JLabel label = new JLabel();
            String[] strings = {"[小说]","[小说]", "[诗歌]","[小说]", "[传记]","[小说]","[烹饪]"};
            label.setText(strings[i]);
            label.setFont(font3);
            label.setForeground(new Color(130, 15, 40));
            boxPanel1.add(label);
            boxPanel1.add(Box.createVerticalStrut(10));
        }
        boxPanel1.setBounds(1380,280,50,200);
        boxPanel1.setBackground(Color.WHITE);
        firstPanel.add(boxPanel1);
        boxPanel2 = new JPanel();
        BoxLayout word2BoxLayout = new BoxLayout(boxPanel2,BoxLayout.Y_AXIS);
        boxPanel2.setLayout(word2BoxLayout);
        for (int i = 0;i<7;i++){
            JLabel label = new JLabel();
            String[] strings = {"在我们相遇之后", "沉睡时光里的爱", "弗罗斯特诗选", "九霄奔云传",
                    "大地悲歌：屈原传","南京，1937","餐桌是我的调色盘"};
            label.setText(strings[i]);
            label.setFont(font2);
            label.setForeground(new Color(154, 154, 154));
            boxPanel2.add(label);
            boxPanel2.add(Box.createVerticalStrut(10));
        }
        boxPanel2.setBounds(1435,280,200,200);
        boxPanel2.setBackground(Color.WHITE);
        firstPanel.add(boxPanel2);
        smallFgImgLabel = new JLabel();  //小分割线
        firstPanel.add(smallFgImgLabel);
        Icon smallFgIcon = new ImageIcon(HomePageJFrame.class.getResource("/img/fg2.png"));
        smallFgImgLabel.setIcon(smallFgIcon);
        smallFgImgLabel.setBounds(1380,250,500,10);

        //最火面板,排序
        hotPanel = new JPanel();
        hotPanel.setBackground(Color.WHITE);
        centerPanel.add("2",hotPanel);
        hotPanel.setLayout(null);
        JButton boyListButton = new JButton("男生畅销榜");
        JButton girlListButton = new JButton("女生畅销榜");
        boyListButton.setBounds(200,20,550,50);
        girlListButton.setBounds(1100,20,550,50);
        boyListButton.setFont(font5);
        boyListButton.setForeground(Color.WHITE);
        boyListButton.setBackground(new Color(130, 15, 40));
        boyListButton.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),0));
        girlListButton.setFont(font5);
        girlListButton.setForeground(Color.WHITE);
        girlListButton.setBackground(new Color(130, 15, 40));
        girlListButton.setBorder(BorderFactory.createLineBorder(new Color(130, 15, 40),0));
        hotPanel.add(boyListButton);
        hotPanel.add(girlListButton);
        //男生榜表格
        // 表头（列名）
        Object[] columnNames = {"排名", "书名","人气值"};
        // 表格所有行数据
        Object[][] rowData = {
                {1,"女总裁的特种神医",1066.1+"万人气"},
                {2,"丹武圣尊",1066.1+"万人气"},
                {3,"宋时行",1066.1+"万人气"},
                {4,"九界独尊",1066.1+"万人气"},
                {5,"生生不灭",1066.1+"万人气"},
                {6,"无上斗魂",1066.1+"万人气"},
                {7,"剑墟",1066.1+"万人气"},
                {8,"完美至尊",1066.1+"万人气"},
                {9,"辣手狂医",1066.1+"万人气"},
                {10,"绝世战魂",1066.1+"万人气"}
        };
        // 创建一个表格，指定 所有行数据 和 表头
        boyTable = new JTable(rowData, columnNames);
        boyTable.setOpaque(false);
        boyTable.setFont(font1);
        boyTable.setRowHeight(45);
        boyTable.setBounds(200,70,550,550);
        hotPanel.add(boyTable);

        //新书面板，爬虫
        newBookPanel = new JPanel();
        newBookPanel.setBackground(Color.WHITE);
        centerPanel.add("5",newBookPanel);
        newBookPanel.setLayout(null);
        JPanel gbPanel = new JPanel();
        gbPanel.setLayout(new GridLayout(2,4,50,20));
        gbPanel.setBounds(25,15,1865,520);
        gbPanel.setBackground(Color.WHITE);
        newBookPanel.add(gbPanel);
        for (int i =0;i<8;i++){
            newBookPanels = new JPanel();//每本新书的面板
            newBookPanels.setBackground(Color.WHITE);
            gbPanel.add(newBookPanels);
            newBookPanels.setLayout(null);
            coverLabels = new JLabel();//加封面
            Icon coverIcon = new ImageIcon(HomePageJFrame.class.getResource("/img/sample.jpg"));
            coverLabels.setIcon(coverIcon);
            coverLabels.setBounds(0,0,185,250);
            newBookPanels.add(coverLabels);
            nameLabels = new JLabel("剑起风云");//加书名
            nameLabels.setFont(font4);
            nameLabels.setBounds(200,10,100,25);
            newBookPanels.add(nameLabels);
            writerLabels = new JLabel("沐潇三生");//加作者名
            writerLabels.setFont(font1);
            writerLabels.setBounds(200,50,100,20);
            newBookPanels.add(writerLabels);
            jsTextAreas = new JTextArea(4,20);//加新书介绍
            jsTextAreas.setFont(font1);
            jsTextAreas.setForeground(new Color(154, 154, 154));
            jsTextAreas.setLineWrap(true);        //激活自动换行功能
            jsTextAreas.setWrapStyleWord(true);            // 激活断行不断字功能
            jsTextAreas.setEditable(false);                  //设置文本框不可编辑
            jsTextAreas.setText("浮尘乱世，乱的不是天下，而是人心。隶属于天风国的顾家，满门忠烈，皆是英豪…");
            jsTextAreas.setBounds(200,90,220,150);
            newBookPanels.add(jsTextAreas);
        }

        //bottomPanel底部面板,空布局，加入smallBottomPanel和两个图片标签，两个按钮
        bottomPanel = new JPanel();
        add(bottomPanel,BorderLayout.SOUTH);
        bottomPanel.setLayout(null);
        bottomPanel.setPreferredSize(new Dimension(getWidth(),326));
        bottomPanel.setBackground(Color.WHITE);
        //bottomPanel，加入分割线图片
        fgImgLabel = new JLabel();
        Icon fgIcon = new ImageIcon(HomePageJFrame.class.getResource("/img/fg.png"));
        fgImgLabel.setIcon(fgIcon);
        fgImgLabel.setBounds(10,5,1900,20);
        bottomPanel.add(fgImgLabel);
        //bookPanel，smallBottomPanel设置为卡片布局，两者一起切换一起切换，同用bookCardLayout布局
        //图书部分放卡片布局
        bookPanel = new JPanel();
        bottomPanel.add(bookPanel);
        bookPanel.setBounds(150,32,196,280);
        bookCardLayout = new CardLayout();
        bookPanel.setLayout(bookCardLayout);
        bookPanel.setBackground(Color.WHITE);
        //卡片布局三本书,默认第一本
        bookLabel1 = new JLabel();
        Icon bookIcon1 = new ImageIcon(HomePageJFrame.class.getResource("/img/book1.jpg"));
        bookLabel1.setIcon(bookIcon1);
        bookPanel.add(bookLabel1);
        bookLabel2 = new JLabel();//第二本
        Icon bookIcon2 = new ImageIcon(HomePageJFrame.class.getResource("/img/book2.png"));
        bookLabel2.setIcon(bookIcon2);
        bookPanel.add(bookLabel2);
        bookLabel3 = new JLabel();//第三本
        Icon bookIcon3 = new ImageIcon(HomePageJFrame.class.getResource("/img/book3.png"));
        bookLabel3.setIcon(bookIcon3);
        bookPanel.add(bookLabel3);
        //前一本，后一本  按钮
        previousButton = new JButton("《");
        bottomPanel.add(previousButton);
        previousButton.setFont(font3);
        previousButton.setForeground(Color.WHITE);
        previousButton.setBackground(new Color(130, 15, 40));
        previousButton.setBounds(70,145,55,30);
        previousButton.addActionListener(this);
        nextButton = new JButton("》");
        bottomPanel.add(nextButton);
        nextButton.setFont(font3);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(130, 15, 40));
        nextButton.setBounds(372,145,55,30);
        nextButton.addActionListener(this);
        //smallBottomPanel设置为卡片布局
        smallBottomPanel = new JPanel();
        smallBottomPanel.setLayout(bookCardLayout);
        bottomPanel.add(smallBottomPanel);
        smallBottomPanel.setBounds(520,32,800,270);
        JPanel introducePanel1 = new JPanel(); //第一本书介绍
        introducePanel1.setSize(800,270);
        introducePanel1.setBackground(Color.WHITE);
        smallBottomPanel.add(introducePanel1);
        introducePanel1.setLayout(null);
        JLabel bookNameLabel1 = new JLabel("莫失莫忘");
        bookNameLabel1.setFont(font5);
        bookNameLabel1.setBounds(0,0,800,50);
        introducePanel1.add(bookNameLabel1);
        JLabel writerLabel1 = new JLabel("秋微 著");
        writerLabel1.setFont(font4);
        writerLabel1.setBounds(0,55,800,30);
        introducePanel1.add(writerLabel1);
        JTextArea textArea1 = new JTextArea(20,30);
        textArea1.setFont(font1);
        textArea1.setForeground(new Color(154, 154, 154));
        textArea1.setLineWrap(true);        //激活自动换行功能
        textArea1.setWrapStyleWord(true);            // 激活断行不断字功能
        textArea1.setEditable(false);                  //设置文本框不可编辑
        textArea1.setText("学会与亲人、挚爱告别是我们一生的功课。" +
                " 十年爱念，四次分离。这是一本关于告别的笔记，写给我们在心底日夜牵挂的人，" +
                "没有好好说再见的人，还有生命里不能触碰的痛。写尽了温柔的、漫长…");
        textArea1.setBounds(0,90,800,170);
        introducePanel1.add(textArea1);
        JPanel introducePanel2 = new JPanel();//第二本书介绍
        introducePanel2.setSize(800,270);
        introducePanel2.setBackground(Color.WHITE);
        smallBottomPanel.add(introducePanel2);
        introducePanel2.setLayout(null);
        JLabel bookNameLabel2 = new JLabel("吕雉的战争");
        bookNameLabel2.setFont(font5);
        bookNameLabel2.setBounds(0,0,800,50);
        introducePanel2.add(bookNameLabel2);
        JLabel writerLabel2 = new JLabel("白晶 著");
        writerLabel2.setFont(font4);
        writerLabel2.setBounds(0,55,800,30);
        introducePanel2.add(writerLabel2);
        JTextArea textArea2 = new JTextArea(20,30);
        textArea2.setFont(font1);
        textArea2.setForeground(new Color(154, 154, 154));
        textArea2.setLineWrap(true);        //激活自动换行功能
        textArea2.setWrapStyleWord(true);            // 激活断行不断字功能
        textArea2.setEditable(false);                  //设置文本框不可编辑
        textArea2.setText("本书撷取了历史上汉代吕后一生中，最富有戏剧性的一些关键时刻，" +
                "集中在短短的一天之内加以刻画。并运用了蒙太奇和意识流等多重艺术表现手法，" +
                "使整个作品拥有一种悲壮而又酸楚的悲剧色彩。通…");
        textArea2.setBounds(0,90,800,170);
        introducePanel2.add(textArea2);
        JPanel introducePanel3 = new JPanel();//第三本书介绍
        introducePanel3.setSize(800,270);
        introducePanel3.setBackground(Color.WHITE);
        smallBottomPanel.add(introducePanel3);
        introducePanel3.setLayout(null);
        JLabel bookNameLabel3 = new JLabel("聚沙成塔");
        bookNameLabel3.setFont(font5);
        bookNameLabel3.setBounds(0,0,800,50);
        introducePanel3.add(bookNameLabel3);
        JLabel writerLabel3 = new JLabel("李胜钜 著");
        writerLabel3.setFont(font4);
        writerLabel3.setBounds(0,55,800,30);
        introducePanel3.add(writerLabel3);
        JTextArea textArea3 = new JTextArea(20,30);
        textArea3.setFont(font1);
        textArea3.setForeground(new Color(154, 154, 154));
        textArea3.setLineWrap(true);        //激活自动换行功能
        textArea3.setWrapStyleWord(true);            // 激活断行不断字功能
        textArea3.setEditable(false);                  //设置文本框不可编辑
        textArea3.setText("这是一本幽默·青春·校园小说，书中经典的句子频出，" +
                "精彩的段落令人拍案叫绝。阅读本书，" +
                "就会发现作者有一种独特的能力，会让读者产生连环笑！" +
                "作者倾注了全部的心血，作品的质量非常之高，…");
        textArea3.setBounds(0,90,800,170);
        introducePanel3.add(textArea3);
        //倒计时线程
        freeLabel = new JLabel("[今日限免]距离截至时间还有：");
        freeLabel.setFont(font4);
        freeLabel.setBounds(1408,100,480,40);
        bottomPanel.add(freeLabel);
        timeLabel = new JLabel();
        TimeThread timeThread = new TimeThread();
//        timeThread.setTimeLabel(timeLabel);
//        timeThread.getTime("2019-04-21 16:38:00");
        timeThread.start();
        timeLabel.setFont(font4);
        timeLabel.setBounds(1408,140,480,40);
        bottomPanel.add(timeLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 判断用户点击了哪个JLabel
        if (e.getSource() == homeButton) {
            cardLayout.show(centerPanel, "1");
        } else if (e.getSource() == hotButton) {
            cardLayout.show(centerPanel, "2");
        } else if (e.getSource() == newBookButton) {
            cardLayout.show(centerPanel, "5");
        }

        if (e.getSource() == previousButton){
            //调用previous显示上一张
            bookCardLayout.previous(bookPanel);
            bookCardLayout.previous(smallBottomPanel);
        }if (e.getSource() == nextButton){
            //调用next显示下一张
            bookCardLayout.next(bookPanel);
            bookCardLayout.next(smallBottomPanel);
        }
    }
    public static void main(String[] args) {
        new HomePageJFrame();
    }
}
