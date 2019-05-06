package com.soft1841.basic1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10086);
        System.out.println("服务器启动");
        OutputStream out;
        String s1;
        Scanner scanner=new Scanner(System.in);
        s1=scanner.nextLine();
        while (true) {
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress() + "上线了");
            out = socket.getOutputStream();
            out.write(s1.getBytes());
            out.close();
            socket.close();
        }
    }
}
