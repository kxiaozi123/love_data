package com.imooc.suanfa;

import com.imooc.suanfa.动态数组.ArrayList;
import com.imooc.suanfa.动态数组.Asserts;
import com.imooc.suanfa.动态数组.Person;

public class Main {
    public static void main(String[] args) {
//        ArrayList list=new ArrayList();
//        list.add(99);
//        list.add(88);
//        list.add(77);
//        list.add(66);
//        list.add(55);
//        for (int i = 0; i < 30; i++) {
//            list.add(i);
//        }
        //list.set(3,80);
        //list.remove(0);
        //Asserts.test(list.get(3)==80);
        //list.add(list.size()-1,100);
        //System.out.println(list);
        ArrayList<Person> person=new ArrayList<>();
        person.add(new Person(10,"jack"));
        person.add(new Person(12,"james"));
        person.add(new Person(15,"rose"));
        person.add(null);
        System.out.println(person.indexOf(null));
        System.out.println(person);
    }
}
