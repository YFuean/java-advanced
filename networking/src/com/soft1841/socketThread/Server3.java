package com.soft1841.socketThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端向服务器端发送文本数据——控制台版
 * 服务器端
 */
public class Server3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread server = new ServerThread(socket);
            new Thread(server).start();
        }
    }
}
class ServerThread implements Runnable{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress() + "连接成功！");
        InputStream inputStream;
        try {
            inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
