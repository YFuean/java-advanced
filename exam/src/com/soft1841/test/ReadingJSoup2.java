package com.soft1841.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ReadingJSoup2 {
    public static void main(String[] args) {
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
        for (Element element : elements){
            //取出div的子元素ul(int j 2行)->il(int i 4列)->title
            for (int j=0;j<2;j++){
                for (int i =0;i<4;i++){
                    Element link = element.child(j).child(i).child(0);
                    //得到a标记的文字内容
                    String titleString = link.text();
                    System.out.println(titleString);
                    //freeBookNameLabels.setText(titleString);
                }
            }
        }
    }
}
