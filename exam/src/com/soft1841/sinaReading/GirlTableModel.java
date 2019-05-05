package com.soft1841.sinaReading;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * 女生表格，实现排序+传值到窗体
 */
public class GirlTableModel extends AbstractTableModel {
    private List<Book> girlBookList =new ArrayList<Book>();
    @Override
    public int getRowCount() {
        return girlBookList.size();
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
        Book book = girlBookList.get(rowIndex);
        if (columnIndex == 0)
            return book.getName();
        return book.getHotNum();
    }
    //传值
    public void setgirlBookList(List<Book> girlBookList) {
        if (girlBookList == null)
            throw new IllegalArgumentException("参数data不能为null。");
        this.girlBookList = girlBookList;
        girlBookList.add(new Book("白日梦小姐",59.6));
        girlBookList.add(new Book("竹马钢琴师",207.3));
        girlBookList.add(new Book("我们的依法时光",32.4));
        girlBookList.add(new Book("枭宠霸道医妃",27.6));
        girlBookList.add(new Book("武灵年少",256.1));
        girlBookList.add(new Book("权诈皇后之奴为卿疆",16.7));
        girlBookList.add(new Book("一面红妆",184.4));
        girlBookList.add(new Book("竹马戏王妃",10.2));
        girlBookList.add(new Book("如愿三生 与卿初见",167.3));
        girlBookList.add(new Book("娘娘万福",107.9));
        sort1(girlBookList);//排序
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
