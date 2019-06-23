package com.soft1841;

import java.io.*;

/**
 * 缓冲字符流学习
 * @author yuefan
 * 2019.4.4
 */
public class BufferedTest {
    public static void main(String[] args) {
        //定义字符串数组
        String content[] ={"吃葡萄不吐葡萄皮","红鲤鱼与绿鲤鱼与驴",
                "母猪的产后护理","Who lives in a pineapple under the sea"};
        //创建文件对象
        File file = new File("word.txt");
        try {
            //创建FileWriter类对象
            FileWriter fw = new FileWriter(file);
            //创建BufferedWriter类对象
            BufferedWriter bufw = new BufferedWriter(fw);
            for (int k =0 ;k<content.length;k++){//循环遍历数组
                //将字符串数组中的元素写到磁盘文件中
                bufw.write(content[k]);
                //将数组中的单个元素以单行的形式写入文件
                bufw.newLine();
            }
            //将BufferedWriter流关闭
            bufw.close();
            //将FileWriter流关闭
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //创建FileReader类对象
            FileReader fr = new FileReader(file);
            //创建BufferedReader类对象
            BufferedReader bufr = new BufferedReader(fr);
            //创建字符串对象
            String s = null;
            //声明int型变量
            int i = 0;
            //如果文件的文本行数不为null，则进入循环
            while ((s = bufr.readLine()) !=null){
                //自变量做自增运算
                i++;
                //输出文件数据
                System.out.println("第"+i+"行:"+s);
            }
            //将BufferedReader流关闭
            bufr.close();
            //将FileReader流关闭
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

