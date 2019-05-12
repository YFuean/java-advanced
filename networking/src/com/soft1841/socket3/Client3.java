package com.soft1841.socket3;

import java.io.*;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("10.40.233.120",10086);
        System.out.println("成功连上服务器");
        //客户端需要发送的文件，先通过字节输入流读入字节数组
        File file = new File("D:/me2.jpg");
        byte[] bytes = new byte[(int) file.length()];
        InputStream inputStream = new FileInputStream(file);
        inputStream.read(bytes);
        //将数组通过缓冲字节输出流传送出去
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        bos.write(bytes);
        inputStream.close();
        bos.close();
    }
}
