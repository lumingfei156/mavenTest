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
        System.out.println( "顺序查找: " +  search.sequentialSearch());
        System.out.println(" 顺序查找(哨兵): " + search.sentinelSearch());
        System.out.println("折半查找: " + search.halfSearch());
        System.out.println("插值查找: " + search.insertSearch());
        System.out.println("斐波那契查找: " + search.fibonacciSearch());
    }
}
