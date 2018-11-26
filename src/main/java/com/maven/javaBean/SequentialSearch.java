package com.maven.javaBean;

/**
 * @author lulu
 */
public class SequentialSearch<T> {
    private T[] array;
    private T key;

    public SequentialSearch(){}

    public SequentialSearch(T[] array,T key){
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

}
