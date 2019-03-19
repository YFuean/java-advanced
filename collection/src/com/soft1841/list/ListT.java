package com.soft1841.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * List练习
 * @author yuefan
 * 2019.3.18
 */
public class ListT {
    public static void main(String[] args) {
        //创建List接口的对象，元素为String类型
        List<String> list = new ArrayList<>();
        //加三个元素
        list.add("java");
        list.add("html");
        list.add("gaoshu");
        //用util的random类随机随机产生[0，list.size()-1]的随机数
        int length = list.size();
        Random random = new Random();
        int index = random.nextInt(length);
        System.out.println(index);
        //取出list中索引为index的元素
        System.out.println(list.get(index));
        //输出所有List元素
        for(int i = 0;i<length;i++){
            System.out.println(list.get(i));
        }
    }
}
