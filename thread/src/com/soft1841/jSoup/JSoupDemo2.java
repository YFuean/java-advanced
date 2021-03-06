package com.soft1841.jSoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

/**
 * 爬取 http://www.bootcss.com/ 页面图片到D盘QLDownload目录，图片名UUID，后缀名
 * 2019.4.19
 */
public class JSoupDemo2 {
    public static void main(String[] args) throws Exception{
        File file;
        InputStream inputStream;
        OutputStream outputStream;
        String url = "http://www.jjwxc.net/fenzhan/ys/";
        //http://www.jjwxc.net/fenzhan/ys/
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        //Elements elementDiv = document.getElementsByClass("jtfm2");
        Elements elements = document.getElementsByClass("ycyqt");
        System.out.println(elements.size());
        for (Element e:elements) {
            Element imgElement = e.child(0).child(0);
            UUID uuid = UUID.randomUUID();
            String imgName = uuid + ".jpg";
            file = new File("D:/QLDownload/" + imgName);
            URL url1 = new URL(imgElement.attr("src"));
            URLConnection uc = url1.openConnection();
            inputStream = uc.getInputStream();
            outputStream = new FileOutputStream(file);
            int temp;
            byte[] buf = new byte[1024];
            while ((temp = inputStream.read(buf))!=-1){
                outputStream.write(buf,0,temp);
            }
            outputStream.close();
            inputStream.close();
        }
    }
}
