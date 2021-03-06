package com.soft1841.socket4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

/**
 * 服务器向客户端发送非文本文件——控制台
 * 客户端
 */
public class Client4 {
    public static void main(String[] args)throws IOException {
        Socket client = new Socket("localhost",10086);
        System.out.println("成功连上服务器");
        InputStream inputStream = client.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        System.out.println("请输入需要保存的路径");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path + "/" + UUID.randomUUID().toString() + ".jpg");
        OutputStream outputStream = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        byte[] bytes = new byte[1024];
        int tmp;
        while ((tmp = bis.read(bytes)) !=-1){
                bos.write(bytes,0,tmp);
            }
        bos.close();
        bis.close();
        client.close();
    }
}
