package com.maven.javaBean;

import sun.security.util.Length;
import sun.swing.plaf.synth.DefaultSynthStyle;

import javax.swing.*;

/**
 * @author lulu
 * @since 2018/11/30
 * 这个类用于实现各种排序
 */
public class ArraySort {

    /**
     * 用于实现冒泡排序(这个版本是向后遍历版本)
     * @param array 需要排序的数组
     */
    public static void bubbleSort(int[] array){
        int temp;
        for (int i = 0;i < array.length;i++){
            //第一次比较i的下一位，如果array[i]比array[j]大，就交换位置，第一轮下来array[0]的位置一定是数组中最小的
            for (int j = i + 1;j < array.length;j++){

                if (array[i] > array[j]){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    /**
     * 这是冒泡排序向前遍历的版本
     * @param array 需要排序的数组
     */
    public static void bubbleSort(int[] array,boolean t){
        int temp;
        for (int i = 0;i < array.length;i++){

            for (int j = array.length - 1;j > i;j--){
                if (array[j] < array[j - 1]){
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 这是冒泡排序向前遍历的版本,而且加了falg优化
     * @param array 需要排序的数组
     * @param t t
     * @param f f
     */
    public static void bubbleSort(int[] array,boolean t,boolean f){
        int temp;
        boolean falg = true;

        for (int i = 0;i < array.length && falg;i++){
            falg = false;
            for (int j = array.length - 1;j > i;j--){
                if (array[j] < array[j - 1]){
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    falg = true;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param array 要排序的数组
     */
    public static void selectSort(int[] array){
        int min;
        int temp;

        for (int i = 0;i < array.length;i++){
            min = i;

            for (int j = i + 1; j < array.length;j++){
                if (array[min] > array[j]){
                    min = j;
                }
            }

            if (i != min){
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }

        }
    }

    /**
     * 插入排序
     * @param array 要排序的数组
     */
    public static void insertSort(int[] array){
        //用于存储array[i]的值，因为有序区向后移一位会导致array[i]的值被覆盖
        int temp;
        int j;
        //默认a[0]为有序区
        for (int i = 1;i < array.length;i++){
            temp = array[i];

            for (j = i - 1;j >=0 && temp < array[j];j-- ){
                array[j + 1] = array[j];
            }
            //当array[j]的值比temp值也就是array[i]的值小的时候，就把temp值插入j的后一位
            array[j + 1] = temp;
        }
    }

    /**
     * 实现希尔排序
     * @param array 要排序的数组
     */
    public static void shellSort(int[] array){
        //用于暂存比较的值
        int temp;
        int j;
        //分组元素的间隔个数，用于决定每条分组的元素个数
        int section = array.length / 2;
        while(section >= 1){
            for (int i = section;i < array.length;i++){
                temp = array[i];
                //首先求和i同组的前一个元素，然后通过比较将小的放到前面
                j = i - section;
                while (j >= 0 && array[j] > temp){
                    array[j + section] = array[j];
                    j = j - section;
                }
                array[j + section] = temp;
            }
            section /=  2;
        }

    }

}