package com.soft1841;

import java.io.*;
import java.util.Scanner;

/**
 * 输出的3个基本程序
 */
public class OutputFile {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/out.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        //1.FileOutputStream
        OutputStream outputStream = new FileOutputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        outputStream.write(bytes);
        String result1 = new String(bytes);
        outputStream.close();
        System.out.println(result1);
        //2.FileWriterStream
        Writer writer = new FileWriter(file);
        char[] chars = new char[(int) file.length()];
        writer.write(chars);
        String result2 = new String(chars);
        writer.close();
        System.out.println(result2);
        //3.打印输入
        InputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);
        String result3 = scanner.nextLine();
        System.out.println(result3);
    }
}
