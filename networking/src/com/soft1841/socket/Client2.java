package com.soft1841.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",10086);
        System.out.println(socket.getRemoteSocketAddress()+"客户端连接成功");
    }
}
