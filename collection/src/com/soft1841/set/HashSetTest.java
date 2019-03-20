package com.soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set接口基础程序,HashSet去重
 * @author yuefan
 * 2019.3.19
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("A");
        set.add("B");

        System.out.println("直接输出set集合");
        System.out.println(set);

        //1.for循环遍历set集合
        System.out.println("for循环遍历");
        Object[] array = set.toArray();
        for (int i = 0; i< array.length; i++){
            System.out.println();
        }
        //2.Iterator迭代器遍历set集合
        System.out.println("Iterator迭代器遍历");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next() + "   ");
        }
        //3.Lambda表达式遍历set集合
        System.out.println("Lambda表达式遍历");
        set.forEach(s -> System.out.println(s));
    }
}
