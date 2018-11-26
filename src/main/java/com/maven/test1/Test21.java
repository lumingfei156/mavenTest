package com.maven.test1;

import com.maven.javaBean.Search;

/**
 * 用于测试有序查找
 * @author lulu
 */
public class Test21 {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9};
        int key = 9;
        Search<Integer> search = new Search<>(array,key);
        System.out.println( search.sequentialSearch());
        System.out.println(search.sentinelSearch());
        System.out.println(search.halfSearch());
        System.out.println(search.insertSearch());
    }
}
