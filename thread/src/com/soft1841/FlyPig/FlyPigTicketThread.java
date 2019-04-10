package com.soft1841.FlyPig;

import javax.swing.*;

public class FlyPigTicketThread extends  Object implements Runnable{
    private JTable table;
    public void setTable(JTable tableNow){this.table = tableNow;}
    private int tickets = 10;
    FlyPigTicketThread tic;
    @Override
    public void run() {
        while (true){
            //同步售票代码块
            synchronized (this){
                if (tickets > 0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
//                    // 表头（列名）
//                    Object[] columnNames = {"售票站点", "当前剩余票数"};
//                    // 表格所有行数据
//                    Object[][] rowData = {
//                            {Thread.currentThread().getName(), --tickets},
//                    };
//                    // 创建一个表格，指定 所有行数据 和 表头
//                    table = new JTable(rowData, columnNames);
                    System.out.println(Thread.currentThread().getName() + "售票，当前票数：" + --tickets);
                }else {
                    break;
                }
            }
        }
    }
}
