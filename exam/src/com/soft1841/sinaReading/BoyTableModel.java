package com.soft1841.sinaReading;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * 男生表格，实现排序+传值到窗体
 */
public class BoyTableModel extends AbstractTableModel {
    private List<Book> boyBookList = new ArrayList<Book>();
    @Override
    public int getRowCount() {
        return boyBookList.size();
    }
    @Override
    public int getColumnCount() {
        //根据实际情况返回列数
        return 2;
    }
    @Override
    public String getColumnName(int column) {
        //根据实际情况返回列名
        if (column == 0)
            return "书名";
        return "火热度";
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = boyBookList.get(rowIndex);
        if (columnIndex == 0)
            return book.getName();
        return book.getHotNum();
    }
    //传值
    public void setboyBookList(List<Book> boyBookList) {
        if (boyBookList == null)
            throw new IllegalArgumentException("参数data不能为null。");
        this.boyBookList = boyBookList;
        boyBookList.add(new Book("剑墟",29.1));
        boyBookList.add(new Book("九界独尊",98.0));
        boyBookList.add(new Book("丹武圣尊",172.1));
        boyBookList.add(new Book("女总裁的特种神医",203.9));
        boyBookList.add(new Book("绝世战魂",17.8));
        boyBookList.add(new Book("完美至尊",87.3));
        boyBookList.add(new Book("辣手狂医",37.7));
        boyBookList.add(new Book("无上斗魂",54.2));
        boyBookList.add(new Book("宋时行",48.9));
        boyBookList.add(new Book("生生不灭",104.6));
        boyBookList.add(new Book("巴黎圣母院",1111.1));
        sort1(boyBookList);//排序
        fireTableDataChanged();
    }
    private static void sort1(List<Book> boyBookList) {
        TreeSet<Book> boyBookSet= new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double num = o1.compareTo(o2);
                return num == 0 ? 1: (int) num;
            }
        });
        boyBookSet.addAll(boyBookList);
        boyBookList.clear();
        boyBookList.addAll(boyBookSet);
    }
}
