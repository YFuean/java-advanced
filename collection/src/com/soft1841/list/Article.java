package com.soft1841.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Article {
    private Integer id;
    private String title;
    private String author;
    private Date writeTime;

    public Article(){}

    public Article(Integer id, String title, String author, Date writeTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.writeTime = writeTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Date writeTime) {
        this.writeTime = writeTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", writeTime=" + writeTime +
                '}';
    }


    public static void main(String[] args) throws ParseException {
        System.out.println("id           "+"标题"+"            作者"+"       时间");
        List<Article> articleList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        articleList.add(new Article(1,"八百标兵奔北坡，标兵怕把炮兵碰","岳岳",format.parse("2019-03-17 22:34:10")));
        articleList.add(new Article(02,"红鲤鱼与绿鲤鱼与驴，驴与绿鲤鱼与红鲤鱼","凡凡",format.parse("2019-03-18 21:50:36")));


        Iterator<Article> iterator = articleList.iterator();
        while (iterator.hasNext()){
            Article article = iterator.next();
            String result;
            result = timeCal(format.format(article.getWriteTime()));
            System.out.println(article.getId()+"    "+article.getTitle().substring(0,10)+"..."+"    "+article.getAuthor()+"    "+result);

        }
    }

    private static String timeCal(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1;
        long diff = 0;
        try {
            d1 = format.parse(time);
            Date now = new Date();
            diff = now.getTime() - d1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        if (seconds < 60) {
            return "刚刚";
        } else if (minutes < 60) {
            return minutes + "分钟前";
        } else if (hours < 24) {
            return hours + "小时前";
        } else {
            return days + "天前";
        }
    }
}

