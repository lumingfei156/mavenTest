package com.maven.test1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test11 {

    public static void main(String[] args) {
        List l = new LinkedList();
//        l.add("1");
//        l.add("2");
//        l.add("3");
//        l.add("4");
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"路明非");
        System.out.println(map.get(1));

    }
}
