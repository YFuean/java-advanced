package com.soft1841;

import java.io.*;

/**
 * 缓冲字节流学习
 * @author yuefan
 * 2019.4.3
 */
public class BufferedStreamTest {
    public static void main(String[] args) {
        //定义字符串数组
        String[] content = {"吃葡萄不吐葡萄皮","红鲤鱼与绿鲤鱼与驴",
                "母猪的产后护理","Who lives in a pineapple under the sea"};
        //创建文件对象
        File file = new File("word.txt");
        FileInputStream fileInputStream = null;
        //创建BufferedInputStream对象
        BufferedInputStream bufferedInputStream = null;
        try{
            //实例化FileInputStream对象
            fileInputStream = new FileInputStream(file);
            //实例化BufferedInputStream对象
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            //创建byte数组，用来存储读取到的内容
            byte[] bContent = new byte[1024];
            //从文件中读取信息，并存入字节数组中
            int len = bufferedInputStream.read(bContent);
            //输出文件数据
            System.out.println("文件中的信息是：" + new String(bContent,0,len));

        } catch (IOException e) {
            System.out.println("io异常");
        }finally {
            try {
                bufferedInputStream.close();
                fileInputStream.close();
            }catch (IOException e){
                System.out.println("io异常");
            }
        }
    }
}
