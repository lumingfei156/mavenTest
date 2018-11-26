package com.maven.javaBean;

import java.util.Collection;

/**
 * @author lulu
 */
public  class Search<T extends Comparable<T>> {
    private T[] array;
    private T key;

    public Search(){}

    public Search(T[] array, T key){
        this.array = array;
        this.key = key;
    }

    public int sequentialSearch(){

        return this.sequentialSearch(this.array,this.key);
    }

    /**
     * 普通的顺序查找
     * @param array 数据源
     * @param key 要查找的数据
     * @return 如果存在就返回数组元素的下标，如果没有就返回-1
     */
    public int sequentialSearch(T[] array,T key){
        int keyIndex = -1;

        for (int i = 0; i < array.length;i++){
            if(key.equals(array[i])){
                keyIndex = i;
                break;
            }
        }
        return keyIndex;
    }

    public int sentinelSearch(){
        return this.sentinelSearch(this.array,this.key);
    }

    /**
     * 设置哨兵优化顺序查找
     * @param array 要查找的数组
     * @param key 要查找的值
     * @return 值在数组的下标，如果没有就返回-1
     */
    public int sentinelSearch(T[] array,T key){
        int keyIndex = -1;
        T sentinel = array[array.length - 1];
        int i = 0;
        while (!array[i].equals(sentinel)){
            if(key.equals(array[i])){
                keyIndex = i;
                break;
            }
            ++i;
        }
        if (key.equals(sentinel)){
            keyIndex = array.length - 1;
        }
        return keyIndex;
    }

    public int halfSearch(){
        return halfSearch(this.array,this.key);
    }

    /**
     * 折半查找法
     * @param array 要查找的数组
     * @param key 关键字
     * @param isNet 用于标识是否是网上的版本，随便传一个值就是了
     * @return 关键字所在的下标
     */
    public  int halfSearch(T[] array, T key,boolean isNet){
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int midIndex;
        int keyIndex = -1;
        //先判断输入的值是否在边界
        if (key.compareTo(array[leftIndex]) == 0){ return leftIndex;}
        if(key.compareTo(array[rightIndex]) == 0){ return rightIndex;}
        //如果输入的值不再边界，那就通过二分的办法检查是否在边界内
        while (rightIndex - leftIndex > 1){
            midIndex = (rightIndex + leftIndex) >> 1;
            if(array[midIndex].compareTo(key) < 0){
                leftIndex = midIndex;
            }else if (array[midIndex].compareTo(key) > 0){
                rightIndex = midIndex;
            }else {
                return midIndex;
            }
        }
        return keyIndex;
    }

    /**
     * 这是大话数据结构的版本
     * @param array 要查询的数组
     * @param key 要查询的值
     * @return key在数组上的下标
     */
    public int halfSearch(T[] array,T key){
        int keyIndex = -1;
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int midIndex;
        T midValue;
        while (leftIndex <= rightIndex){
            midIndex = (rightIndex + leftIndex) >> 1;
            midValue = array[midIndex];
            if(midValue.compareTo(key) < 0){
                leftIndex = midIndex + 1;
            }else if(midValue.compareTo(key) > 0){
                rightIndex = midIndex - 1;
            }else {
                return midIndex;
            }
        }
        return keyIndex;
    }

    public int insertSearch(){
        return this.insertSearch(this.array,this.key);
    }

    /**
     * 插值查找
     * @param array 要查找的数组
     * @param key 要查找的值
     * @return key对应的数组下标
     */
    public int insertSearch(T[] array,T key){
        int keyIndex = -1;
        int leftIndex = 0;
        int rigthIndex = array.length - 1;
        int midIndex ;
        T midValue = null;
        while (leftIndex <= rigthIndex){
            //由于是泛型，现在只能用哈希值还进行加减了
            midIndex = leftIndex +
                        (rigthIndex - leftIndex) *
                        (key.hashCode() - array[leftIndex].hashCode())
                        /(array[rigthIndex].hashCode() - array[leftIndex].hashCode());
            midValue = array[midIndex];
            if(midValue.compareTo(key) < 0){
                leftIndex = midIndex + 1;
            }else if(midValue.compareTo(key) > 0){
                rigthIndex = midIndex - 1;
            }else {
                return midIndex;
            }
        }
        return keyIndex;
    }

}
