package com.soft1841;

/**
 * 模拟队员入场
 * @author yuefan
 * 2019.4.8
 */
public class Team{
    public static void main(String[] args) {
        System.out.println("A队B队开始入场");
        A a = new A();
        a.start();
        B b = new B();
        b.start();
    }
}
class A extends Thread{
    public void run(){
        for (int i = 1;i <= 11;i++){
            System.out.print("a" + i + "  ");
        }
    }
}

class B extends Thread{
    public void run(){
        for (int i = 1;i <= 11;i++){
            System.out.print("b" + i + "  ");
        }
    }
}