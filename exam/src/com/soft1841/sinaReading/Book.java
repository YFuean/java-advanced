package com.soft1841.sinaReading;

/**
 * 图书类
 */
public class Book {
    private String name;
    private Double hotNum;
    public Book(){}

    public Book(String name, Double hotNum) {
        this.name = name;
        this.hotNum = hotNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHotNum() {
        return hotNum;
    }

    public void setHotNum(Double hotNum) {
        this.hotNum = hotNum;
    }

    @Override
    public String toString() {
        return  name + " " + hotNum;
    }
    public double compareTo(Book book) {
        return book.getHotNum()-this.getHotNum();
    }
}
