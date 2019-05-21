package com.soft1841.designpatten.adapter;

/**
 * 适配器模式
 */
public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("特长生招募：");
        Student student1 = new Student() {
            @Override
            public void javaStudy() {
                System.out.println("我是一名Java大神");
            }
        };
        student1.javaStudy();
        Student student2 = new Student() {
            @Override
            public void playBasketball() {
                System.out.println("我篮球打得好");
            }
            @Override
            public void playFootball(){
                System.out.println("足球也踢得好");
            }
        };
        student2.playBasketball();
        student2.playFootball();
    }
}
