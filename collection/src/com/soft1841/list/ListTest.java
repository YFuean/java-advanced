package com.soft1841.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List接口的基础练习，arrayList可重复列表
 * @author yuefan
 * 2019.3.19
 */
public class ListTest {
    public static void main(String[] args) {
        //1.创建一个list对象，加入元素
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //2.for循环遍历集合
        for (int i = 0; i < list.size() ; i++){
            System.out.println(list.get(i));
        }
        //3.Iterator迭代器遍历集合
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //4.Lambda表达式遍历集合
        list.forEach(s -> System.out.println(s));
    }
}
