package com.java.util;

/**
 * Integer类的练习
 * @author yuefan
 * 2019.3.12
 */
public class IntegerDemo {
    private static String convert(int num,int radix){
        //创建一个stringBuffer，用来存放结果字符串
        StringBuffer stringBuffer = new StringBuffer();
        //被除数下不为0，就循环
        while (num != 0){
            //求出余数
            int remainder = num % radix;
            //将余数加入stringBuffer
            stringBuffer.append(String.valueOf(remainder));
            //更新被除数为商
            num = num / radix;
        }
        return stringBuffer.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(convert(22,2));
    }
}
