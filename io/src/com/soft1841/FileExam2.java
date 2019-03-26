package com.soft1841;

import java.io.*;
import java.util.Scanner;

public class FileExam2 {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        byte[] bytes = string.getBytes();

        File destFile = new File("D:/test.txt");
        FileOutputStream out = new FileOutputStream(destFile);
        out.write(bytes);
        out.close();
    }
}
