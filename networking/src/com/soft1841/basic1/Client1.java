package com.soft1841.basic1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 */
public class Client1 {
    public static void main(String[] args) throws IOException {
        //创建客户端对象，指定连接的服务器IP和端口
        Socket socket = new Socket("10.40.152.78",10086);
        //获取客户端的输入流
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        System.out.println("服务端发送的数据是：" + new String(bytes));
        inputStream.close();
        socket.close();
    }
}
