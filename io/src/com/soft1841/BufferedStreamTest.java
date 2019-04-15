package com.soft1841;

import java.io.*;

/**
 * 缓冲字符流学习
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
//        //创建FileOutputStream对象
//        FileOutputStream fileOutputStream = null;
//        //创建BufferedOutputStream对象
//        BufferedOutputStream bufferedOutputStream = null;
        //创建FileInputStream对象
        FileInputStream fileInputStream = null;
        //创建BufferedInputStream对象
        BufferedInputStream bufferedInputStream = null;

//        try{
//            //实例化FileOutputStream对象
//            fileOutputStream = new FileOutputStream(file);
//            //实例化BufferedOutputStream对象
//            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            //创建可以容纳为1024个字节数组的缓冲区
//            byte[] bContent = new byte[1024];
//            //循环遍历数组
//            for (int k = 0;k < content.length;k++) {
//                //将遍历到的数组内容转换为字节数组
//                bContent = content[k].getBytes();
//                //将字节数组内容写入文件
//                bufferedOutputStream.write(bContent);
//            }
//            System.out.println("写入成功！\n");
//        }catch (IOException e){
//            System.out.println("io异常");
//        }finally {
//            try {
//                bufferedOutputStream.close();
//                fileOutputStream.close();
//            }catch (IOException e){
//                System.out.println("io异常");
//            }
//        }
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
