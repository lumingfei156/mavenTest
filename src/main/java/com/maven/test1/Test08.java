package com.maven.test1;

import com.maven.javaBean.Person;

import java.util.ArrayList;
import java.util.List;

public class Test08 {
    private String value = null;

    public Test08(String v){
        value = v;
    }

    public boolean equals(Test08 o){
        if(o == this)
            return true;
        if (o instanceof Test08){
            Test08 test = (Test08)o;
            return value.equals(test.value);
        }
        return false;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        Test08 test1 = new Test08("object");
        Test08 test2 = new Test08("object");
        Test08 test3 = new Test08("object");
        Object test4 = new Test08("object");
        list.add(test1);

        System.out.println(list.contains(test2));
//        System.out.println(test2.equals(test3));
//        System.out.println(test3.equals(test4));


    }
}
