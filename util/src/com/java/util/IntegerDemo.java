package com.java.util;

import java.util.Stack;

/**
 * Integer类的练习
 * @author yuefan
 * 2019.3.12
 */
public class IntegerDemo {
//    public static void main(String[] args) {
//        int num = Integer.parseInt("222");
//        Integer iNum = Integer.valueOf("222");
//        System.out.println(iNum.equals(num));
//        String str2 = Integer.toBinaryString(num);
//        String str3 = Integer.toHexString(num);
//        String str4 = Integer.toOctalString(num);
//        String str5 = Integer.toString(num,9);
//        System.out.println(str2);
//        System.out.println(str3);
//        System.out.println(str4);
//        System.out.println(str5);
//    }

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
