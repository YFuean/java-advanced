package com.soft1841.excam.bigwork1;

/**
 * 定义赛车类
 */
public class Racing {
    private Integer id;
    private String name;
    private Integer price;

    public Racing(){}

    public Racing(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  id + "    " + name +"    "+ price ;
    }

    public int compareTo(Racing racing) {
        return racing.getPrice()-this.getPrice();
    }
}
