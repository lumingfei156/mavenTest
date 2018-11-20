package com.maven.test1;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayListTest {

    public static void main(String[] args) {
//        ArrayList<String> arrayList = new ArrayList<>();
//        ArrayList<String> aList = new ArrayList<>(11);
//        HashSet<String> hashSet = new HashSet<>();
//        arrayList.add("hello1");
//        arrayList.add("hello2");

//        System.out.println("the componentType of the Integer[] is :" + Integer[].class.getComponentType());

//        Integer[] o = (Integer[])Array.newInstance(Integer[].class.getComponentType(), 10);
//        for (int i = 0;i < 10;i++){
//            o[i] = i;
//        }

//        Object[] newType = new Object[11];
//        System.arraycopy(o,0,newType,0,o.length);

//        for (Object temp : newType){
//            System.out.println(temp);
//        }

//        System.out.println(o[0]);
//        System.out.println(o[1]);
        ArrayList a = new ArrayList();

        Integer[] test = {12,52,36,41,25,13};
        Arrays.sort(test);
        for(Integer temp : test)
            System.out.print(temp + " ");
        System.out.println("\n");
        int k = Arrays.binarySearch(test, 15);
        int left = Math.abs(k) -1;
        int right = Math.abs(k);
        System.out.println(" left :" + left);
        System.out.println(" right :" + right);
    }
}
