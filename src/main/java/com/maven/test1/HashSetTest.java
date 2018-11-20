package com.maven.test1;

import com.maven.javaBean.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetTest {

    public static void main(String[] args) {
//        HashSet<Person> hashSet = new HashSet<Person>();
        String str1 = new String ("hello");
        String str2 = new String ("hello");
        List<String> list = new ArrayList<>();
        list.add(str1);
//        list.add(str2);

        System.out.println(list.contains(str2));

    }
}
