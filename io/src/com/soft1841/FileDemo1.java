package com.soft1841;

import java.io.File;
import java.io.IOException;

/**
 * File基础程序
 * @author yuefan
 * 2019.3.25
 */
public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/README.md");
        //如果file不存在，则创建新文件
        if (!file.exists()){
            file.createNewFile();
        }
    }
}
