package com.soft1841.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet排序
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(-3);
        set.add(90);
        set.add(-29);
        set.add(57);

        Iterator<Integer> it = set.iterator();
        System.out.print("set集合元素：");
        while (it.hasNext()){
            System.out.print(it.next() + "   ");
        }
    }
}
