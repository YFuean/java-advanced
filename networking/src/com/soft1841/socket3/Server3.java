package com.soft1841.socket3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * 客户端向服务器发送非文本文件
 */
public class Server3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动");
        Socket socket;
        while (true){
            socket = serverSocket.accept();
            ServerThread3 server = new ServerThread3(socket);
            new Thread(server).start();
        }
    }
}
class ServerThread3 implements Runnable{
    private Socket socket;

    public ServerThread3(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println("客户端" + socket.getInetAddress() + "连接成功");
        try {
            //从客户端的输入流中读
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //写到服务器指定路径
            File file = new File("D:/QLDownload/" + UUID.randomUUID().toString());
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            //缓冲区
            byte[] date = new byte[1024];
            int temp;
            while ((temp = bis.read(date)) !=-1){
                bos.write(date,0,temp);
            }
            bos.close();
            bis.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
