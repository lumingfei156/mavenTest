package com.maven.test1;

import com.maven.javaBean.Person;

public class Test03 {

    public static void main(String[] args) throws Throwable {

//            boolean s = true;
//        Person p = new Person();
//        p.finalize();

//        Thread.sleep(2000000);
//        System.out.println(true | true);
        System.out.println(caonima());


    }

    public static int caonima(){
        int i = 1;
        try {
            if(true) return ++i;
        }finally {
            ++i;
            return i;
        }
//        return i;
    }



}
