package com.soft1841.socket4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器向客户端发送非文本文件——控制台
 * 服务器端
 */
public class Server4 {
    public static void main(String[] args)throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread4 serverThread4 = new ServerThread4(socket);
            new Thread(serverThread4).start();
        }
    }
}
class ServerThread4 implements Runnable{
    private Socket socket;

    public ServerThread4(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端" + socket.getInetAddress() + "连接成功");
        try {
            File file = new File("D:/QLDownload/me2.jpg");
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes);
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
