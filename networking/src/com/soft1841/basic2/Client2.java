package com.soft1841.basic2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("39.96.182.225",8080);
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要发送的信息：");
        String info = scanner.nextLine();
        outputStream.write(info.getBytes());
        outputStream.close();
        socket.close();
    }
}
