package com.soft1841.socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 服务器向客户端发送信息——控制台版
 * client端，通过BufferedReader读取文本内容
 */
public class Client3 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",10086);
        System.out.println("成功连上服务器");
        //声明BufferedReader对象，通过客户端的输入流接收信息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String str = bufferedReader.readLine();
        System.out.println("服务器端输出内容：" + str) ;
        bufferedReader.close();
        client.close();

    }
}
