package com.soft1841;

import java.io.File;
import java.io.IOException;

/**
 * 输出的3个基本程序
 */
public class OutputFile {
    public static void main(String[] args) throws IOException {
        String string = new String("I love java");
        File file = new File("D:/out.txt");
        if (!file.exists()){
            file.createNewFile();
        }

        //1.FileOutputStream

        //2.FileWriterStream

        //3.

    }
}
