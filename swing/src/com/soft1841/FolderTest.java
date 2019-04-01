package com.soft1841;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 遍历D：/QLDownload下所有图片文件
 * @author yuefan
 * 2019.4.1
 */
public class FolderTest {
    public static void main(String[] args) {
        //要遍历的路径
        String path = "D:/QLDownload";
        //获取其file对象
        File file = new File(path);
        //遍历path下的文件和目录，放在file数组中
        File[] fs = file.listFiles();
        //遍历File[]数组
        for (File f:fs) {
            //获取文件扩展名
            String fileName = f.getName();
            List<File> list = new ArrayList<File>();
            if (fileName.endsWith(".jpg")||fileName.endsWith(".png")){
                list.add(f);
                System.out.println(f);
            }
        }


    }
}
