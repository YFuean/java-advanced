package com.soft1841.socket1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端向服务器端发送文本数据——控制台版
 * 客户端
 */
public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",10086);
        System.out.println("成功连上服务器");
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter;
        System.out.println("请输入一行信息");
        String s = scanner.nextLine();
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        bufferedWriter.write(s);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
