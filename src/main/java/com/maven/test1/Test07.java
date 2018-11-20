package com.maven.test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test07 {

    public static void main(String[] args) {
        List l = new ArrayList();

        List<Integer> tempList = new LinkedList<>();
        for (int i  = 0;i < 100000;i++){
            tempList.add(i);
        }
        long t1,t2 = 0;
        t1 = System.currentTimeMillis();
        for (int i = 0;i < tempList.size();i++){
            tempList.get(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("第一种遍历时间为: " + (t2-t1) + "(ms)");

        t1 = System.currentTimeMillis();
        for (Integer temp : tempList){

        }
        t2 = System.currentTimeMillis();
        System.out.println("第二种遍历时间为: " + (t2-t1) + "(ms)");

        t1 = System.currentTimeMillis();
        Iterator<Integer> iterator = tempList.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        t2 = System.currentTimeMillis();
        System.out.println("第三种遍历时间为: " + (t2-t1) + "(ms)");

        t1 = System.currentTimeMillis();
        for (int i = 0,length = tempList.size();i < length;i++){
            tempList.get(i);
        }
        t2 = System.currentTimeMillis();
        System.out.println("第四种遍历时间为: " + (t2-t1) + "(ms)");

    }
}
