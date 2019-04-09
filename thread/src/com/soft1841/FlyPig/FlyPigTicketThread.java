package com.soft1841.FlyPig;

import javax.swing.*;

public class FlyPigTicketThread extends  Object implements Runnable{
    private JTable table;
    public void setTable(JTable tableNow){this.table = tableNow;}
    private int tickets = 10;

    @Override
    public void run() {

        Thread thread1 = new Thread("上海虹桥站");
        thread1.start();
        Thread thread2 = new Thread("昆山南站");
        thread2.start();
        Thread thread3 = new Thread("苏州站");
        thread3.start();
//        Thread thread4 = new Thread(tic,"惠山站");
//        thread4.start();
//        Thread thread5 = new Thread(tic,"常州站");
//        thread5.start();
//        Thread thread6 = new Thread(tic,"丹阳站");
//        thread6.start();
//        Thread thread7 = new Thread(tic,"仙林站");
//        thread7.start();
        while (true){
            //同步售票代码块
            synchronized (this){
                if (tickets > 0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
                    // 表头（列名）
                    Object[] columnNames = {"售票站点", "当前剩余票数"};
                    // 表格所有行数据
                    Object[][] rowData = {
                            {Thread.currentThread().getName(), --tickets},
                    };
                    // 创建一个表格，指定 所有行数据 和 表头
                    table = new JTable(rowData, columnNames);
                    System.out.println(Thread.currentThread().getName() + "售票，当前票数：" + --tickets);
                }else {
                    break;
                }
            }
        }
    }
}
