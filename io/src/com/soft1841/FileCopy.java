package com.soft1841;

import java.io.*;
import java.util.UUID;

/**
 * copy文件，并生成新的文件名
 * @author yuefan
 * 2019.3.26
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        //指定源文件
        File srcFile = new File("D:/blue.jpg");

        String srcFileName = srcFile.getName();
        int position = srcFileName.indexOf(".");
        //获取源文件的扩展名
        String suffixName = srcFileName.substring(position + 1);
        //新的主文件名
        String newName = UUID.randomUUID().toString();

        //指定目标文件
        File destFile = new File("D:/" + newName + "." + suffixName);
        //创建一个字节数组，大小为源文件，转换为int
        byte[] bytes = new byte[(int) srcFile.length()];
        //创建字节输入流
        InputStream inputStream = new FileInputStream(srcFile);
        //将源文件读入字节数组
        inputStream.read(bytes);
        //创建字节输出流
        OutputStream outputStream = new FileOutputStream(destFile);
        //将字节数组通过字节输出流写入目标文件
        outputStream.write(bytes);
        //关闭输入、输出流
        inputStream.close();
        outputStream.close();
    }
}
