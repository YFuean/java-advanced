package com.soft1841.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;

/**
 * 爬虫
 */
public class ReadingJSoup {
    private JLabel freeBookNameLabels;
    private JTextArea freeJsTextAreas;
    private String titleString;
    private String[] strings;
    //1.指定目标页面链接
    String url = "http://book.sina.com.cn/";
    //2.建立与目标页面的连接
    Connection connection = Jsoup.connect(url);
    //3.解析目标页面
    Document document = null;{
        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //4.获取页面中所有的class为title的元素，本例在页面中可以检查元素，是div
    Elements elements = document.getElementsByClass("s-right-warp");

    //遍历标题
    public void setFreeBookNameLabels(JLabel freeBookNameLabels){
        this.freeBookNameLabels = freeBookNameLabels;
        for (Element element : elements){
            //取出div的子元素ul(int j 2行)->il(int i 4列)->title
            for (int j=0;j<2;j++){
                for (int i = 0;i<4;i++){
                    Element link= element.child(j).child(i).child(0);
                    //得到a标记的文字内容
                    titleString = link.text();
                    System.out.println(titleString);
                    freeBookNameLabels.setText(titleString);

//                    String[] arr = new String[8];
//                    for(int x = 0; x < 8; x++){
//                        arr[x] = titleString;
//                        System.out.println(arr[x]);
//                    }
                }
            }


        }
    }

    //遍历内容
//    public void setFreeJsTextAreas(JTextArea freeJsTextAreas){
//        this.freeJsTextAreas = freeJsTextAreas;
//        for (Element element : elements){
//            //取出div的子元素ul(int j 2行)->il(int i 4列)->title
//            for (int j=0;j<2;j++){
//                for (int i =0;i<4;i++){
//                    Element link = element.child(j).child(i).child(2);
//                    //得到a标记的文字内容
//                    String contentString = link.text();
//                    System.out.println(contentString);
//                    freeJsTextAreas.setText(contentString);
//                }
//            }
//        }
//    }
}
