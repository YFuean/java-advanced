package com.soft1841.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程的服务端
 */
public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动成功");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread();
            serverThread.setSocket(socket);
            new Thread(serverThread).start();
        }
    }
}
class ServerThread implements Runnable{

    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
