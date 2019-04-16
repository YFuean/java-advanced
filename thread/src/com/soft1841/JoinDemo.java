package com.soft1841;

/**
 * 用join()方法的倒计时程序
 * 2019.4.17
 */
public class JoinDemo extends Thread {
    public void run(){
        for (int i = 10;i > 0;i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        JoinDemo joinDemo = new JoinDemo();
        //新生状态
        Thread thread = new Thread(joinDemo);
        //就绪状态
        thread.start();
        System.out.println("开始倒数");
        try {
            thread.sleep(2000);
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("节目开始");
    }
}
