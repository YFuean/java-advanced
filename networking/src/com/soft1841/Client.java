package com.soft1841;

import java.io.IOException;
import java.net.Socket;

/**
 * 网络编程起步
 * 2019.5.6
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端对象，指定连接的服务器IP和端口
        Socket socket = new Socket("192.168.43.184",10086);
        System.out.println("已和服务器建立连接，远程主机地址：" + socket.getRemoteSocketAddress());

    }
}
