package com.soft1841.designpatten.adapter;

public abstract class Student implements Study,Sports {
    @Override
    public void playBasketball() { }
    @Override
    public void playFootball() { }
    @Override
    public void javaStudy() { }
    @Override
    public void mathStudy() { }
}
