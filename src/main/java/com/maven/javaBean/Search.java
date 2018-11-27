package com.maven.javaBean;

import java.util.Arrays;
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
        final int maxSize = array.length;
        int midIndex ;
        T midValue = null;
        while (leftIndex <= rigthIndex){
            //由于是泛型，现在只能用哈希值还进行加减了
            midIndex = leftIndex +
                        (rigthIndex - leftIndex) *
                        (key.hashCode() - array[leftIndex].hashCode())
                        /(array[rigthIndex].hashCode() - array[leftIndex].hashCode());
            //检查是否数组越界
            if (midIndex < 0 || midIndex > maxSize - 1){
                return keyIndex;
            }
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

    public int fibonacciSearch(){
        return this.fibonacciSearch(this.array,this.key);
    }

    /**
     * 斐波那契查找
     * 采用最接近查找长度的斐波那契数值来确定拆分点（这是重点，确定拆分点）
     * @param array 要查找的数组
     * @param key 要查找的值
     * @return key在数组的下标
     */
    public int fibonacciSearch(T[] array,T key){
        int keyIndex = -1;
        //大话数据结构定义为1，我也不知道为什么要这样写，可是网上定义为0，lowIndex是最低的查找位置
        int lowIndex = 0;
        int hightIndex = array.length - 1;
        final int arrayLength = array.length;

        //斐波那契数组下标
        int k = 0;

        int midIndex = 0;
        //协助查找的斐波那契数组，斐波那契数组用于定位拆分点，所谓的拆分点就是要和key值对比的下标位置
        int[] fb = this.makeFiboArray(arrayLength);

        //从斐波那契数组中获取要扩展的长度，就是说构造斐波那契元素长度的数组，用最后一位补足数组
        while (array.length > fb[k] - 1){
            ++k;
        }
        //用数组最后一位元素补足多出来的长度
        T[] tempArray = Arrays.copyOf(array,fb[k]);
        for (int i = arrayLength;i < fb[k] - 1;i++){
            tempArray[i] = array[arrayLength - 1];
        }
        //开始比较
        while (lowIndex <= hightIndex){
            //拆分点就是数组中第fb[k - 1]个元素，通过比较这个点决定高低指针的移动
            midIndex = lowIndex + fb[k - 1] - 1;
            if (tempArray[midIndex].compareTo(key) < 0){
                lowIndex = midIndex + 1;
                //低指针上移之后，高低指针之间的元素也是一个斐波那契元素长度的子数组，这时候再次找拆分点就是了
                k = k - 2;
            }else if (tempArray[midIndex].compareTo(key) > 0){
                hightIndex = midIndex - 1;
                k = k - 1;
            }else {
                if(midIndex > arrayLength - 1){
                    return arrayLength - 1;
                }else {
                    return midIndex;
                }
            }
        }
        return keyIndex;
    }

    /**
     * @param length 斐波那契数组的长度
     * @return 斐波那契数组
     */
    private int[] makeFiboArray(int length){
        int[] array = null;
        final int minLength = 2;
        if (length < minLength){
            throw new IllegalArgumentException("斐波那契数组必须要有两个元素！"); }
        array = new int[length];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2;i < length;i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

}
