package com.soft1841.excam;
/**
 * Map和List的整合练习
 * @author yuefan
 * 2019.3.19
 */

import java.util.*;

public class Student {
    private Integer id;
    private String name;

    public Student(){}

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  id +"   " + name ;
    }

    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(1,"岳凡"));
        list1.add(new Student(2,"夏铭慧"));
        list1.add(new Student(3,"王昭君"));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(4,"周国庆"));
        list2.add(new Student(5,"高金通"));
        list2.add(new Student(6,"田震"));

        Map<String,List<Student>> map = new HashMap<>();
        map.put("女生",list1);
        map.put("男生",list2);

        Iterator<Map.Entry<String,List<Student>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,List<Student>> entry = iterator.next();
            System.out.println(entry.getKey());
            List<Student> list = entry.getValue();
            for (Student s :list){
                System.out.print("学号：" + s.getId() + "    " + "姓名：" + s.getName());
                System.out.println();
            }
        }
    }
}
