package com.soft1841;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExam extends JFrame {
    public FlowLayoutExam(){
        setTitle("题目");
        Container container = getContentPane();
        setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        container.add(new JLabel("下面四句诗，哪句是描写夏天的？"));
        container.add(new JLabel("A.秋风萧瑟天气凉，草木摇荡露为霜。"));
        container.add(new JLabel("B.白雪纷纷何所似，撒盐空中差可拟。"));
        container.add(new JLabel("C.接天莲叶无穷碧，映日荷花别样红。"));
        container.add(new JLabel("D.竹外桃花三两枝，春江水暖鸭先知。"));
        setSize(300,200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new FlowLayoutExam();
    }
}
