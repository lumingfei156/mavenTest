package com.maven.test1;

import com.maven.javaBean.SequentialSearch;

/**
 * 用于测试顺序查找
 * @author lulu
 */
public class Test21 {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9};
        int key = 9;
        SequentialSearch<Integer> search = new SequentialSearch<>(array,key);
        System.out.println( search.sequentialSearch());
        System.out.println(search.sentinelSearch());
    }

}
