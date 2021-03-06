package com.soft1841.socket2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器向客户端发送信息——控制台版
 * server端使用打印流向客户端输入文本内容
 */
public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread2 server = new ServerThread2(socket);
            new Thread(server).start();
        }
    }
}
class ServerThread2 implements Runnable{
    private Socket socket;

    public ServerThread2(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端" + socket.getInetAddress());
        String info = "小喇叭开始广播啦";
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream printStream = new PrintStream(outputStream);
        printStream.print(info);
        printStream.close();
    }
}
