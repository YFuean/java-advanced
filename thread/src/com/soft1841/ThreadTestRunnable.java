package com.soft1841;

/**
 * 实现Runnable接口创建线程
 * @author yuefan
 * 2019.4.8
 */
public class ThreadTestRunnable extends Object implements Runnable{
    private int count = 10;
    @Override
    //重写run()方法
    public void run() {
        while (true){
            //打印count变量
            System.out.print(count + "   ");
            //使count变量自减，当自减为0时，退出循环
            if (--count == 0){
                break;
            }
        }
    }
    public static void main(String[] args) {
        //创建线程对象
        ThreadTest test = new ThreadTest();
        //启动线程
        test.start();
    }
}
