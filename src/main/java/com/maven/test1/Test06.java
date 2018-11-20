package com.maven.test1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test06 {

    public static void main(String[] args) {
        String[] s = new String[]{"1","2"};
        listAll(Arrays.asList(s),"");
    }

    public static void listAll(List candidate,String prefix){

        System.out.println(prefix);

        for (int i = 0, length = candidate.size();i < length; i++){

            List temp = new LinkedList(candidate);
            listAll(temp,prefix + temp.remove(i));
        }
    }
}
