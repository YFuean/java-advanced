package com.soft1841.exam.bigwork1;

import java.util.*;

/**
 * list,map,set综合实例
 * @author yuefan
 * 2019.3.20
 */
public class sample {
    public static void main(String[] args) {
        //制作列表1，加入元素
        List<com.soft1841.excam.bigwork1.Racing> list1 = new ArrayList<>();
        list1.add(new com.soft1841.excam.bigwork1.Racing(1,"雷霆风暴",57280));
        list1.add(new com.soft1841.excam.bigwork1.Racing(2,"魔王",61090));
        list1.add(new com.soft1841.excam.bigwork1.Racing(3,"极光",59370));
        list1.add(new com.soft1841.excam.bigwork1.Racing(7,"qq飞车",1000000));
        //输出list1
        System.out.println("*****list1输出*****");
        list1.forEach(racing -> System.out.println(racing));

        //制作列表1，加入元素
        List<com.soft1841.excam.bigwork1.Racing> list2 = new ArrayList<>();
        list2.add(new com.soft1841.excam.bigwork1.Racing(4,"大Q吧",9999));
        list2.add(new com.soft1841.excam.bigwork1.Racing(5,"劳德曼",11880));
        list2.add(new com.soft1841.excam.bigwork1.Racing(6,"寒凌",12320));
        System.out.println("*****list2输出*****");
        list2.forEach(racing -> System.out.println(racing));

        //输出排序后的list1
        sort1(list1);
        System.out.println("*****list1排序后*****");
        list1.forEach(racing -> System.out.println(racing));
        //输出排序后的list2
        sort2(list2);
        System.out.println("*****list2排序后*****");
        list2.forEach(racing -> System.out.println(racing));



        Map<String,List<com.soft1841.excam.bigwork1.Racing>> map = new HashMap<>();
        map.put("A车",list1);
        map.put("B车",list2);

        Iterator<Map.Entry<String,List<com.soft1841.excam.bigwork1.Racing>>> iterator = map.entrySet().iterator();
        System.out.println("***加入map后输出***");
        while (iterator.hasNext()){
            Map.Entry<String,List<com.soft1841.excam.bigwork1.Racing>> entry = iterator.next();
            System.out.println(entry.getKey());
            List<com.soft1841.excam.bigwork1.Racing> list = entry.getValue();
            for (com.soft1841.excam.bigwork1.Racing racing : list){
                System.out.println("id:" + racing.getId() + "    名称：" +
                        racing.getName() + "   价格：" + racing.getPrice());
                System.out.println();
            }
        }

    }

    //通过treeSet排序
    public static void sort1(List<com.soft1841.excam.bigwork1.Racing> list1) {
        //将list中所有的元素添加到TreeSet集合中,对其排序,保留重复
        TreeSet<com.soft1841.excam.bigwork1.Racing> set1 = new TreeSet<>(new Comparator<com.soft1841.excam.bigwork1.Racing>() {
            @Override
            public int compare(com.soft1841.excam.bigwork1.Racing o1, com.soft1841.excam.bigwork1.Racing o2) {
                int num = o1.compareTo(o2);
                return num == 0 ? 1: num;
            }
        });
        //将list集合中所有元素添加到TreeSet集合中对其排序
        set1.addAll(list1);
        //清空list集合
        list1.clear();
        //将TreeSet集合中排好序的元素添加到list集合中
        list1.addAll(set1);
    }
    public static void sort2(List<com.soft1841.excam.bigwork1.Racing> list2) {
        //将list中所有的元素添加到TreeSet集合中,对其排序,保留重复
        TreeSet<com.soft1841.excam.bigwork1.Racing> set2 = new TreeSet<>(new Comparator<com.soft1841.excam.bigwork1.Racing>() {
            @Override
            public int compare(com.soft1841.excam.bigwork1.Racing o1, com.soft1841.excam.bigwork1.Racing o2) {
                int num = o1.compareTo(o2);
                return num == 0 ? 1: num;
            }
        });
        //将list集合中所有元素添加到TreeSet集合中对其排序
        set2.addAll(list2);
        //清空list集合
        list2.clear();
        //将TreeSet集合中排好序的元素添加到list集合中
        list2.addAll(set2);
    }
}
