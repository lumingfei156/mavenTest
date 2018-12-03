package com.maven.test1;

import com.maven.javaBean.ArraySort;


/**
 * @author lulu
 * @since 2018/11/30
 * 排序测试类
 */
public class Test25 {

    public static void main(String[] args) {
        int[] array = new int[]{9,1,5,8,3,7,4,6,2};
        ArraySort.bubbleSort(array);
        System.out.println("冒泡排序向后遍历的版本：");
        for (int temp : array){
            System.out.print(temp + " ");
        }

        int[] array1 = new int[]{9,1,5,8,3,7,4,6,2};
        ArraySort.bubbleSort(array1,false);
        System.out.println("\n冒泡排序向前遍历的版本：");
        for (int temp : array1){
            System.out.print(temp + " ");
        }

        int[] array2 = new int[]{9,1,5,8,3,7,4,6,2};
        ArraySort.bubbleSort(array2,false,false);
        System.out.println("\n冒泡排序向前遍历的优化版本：");
        for (int temp : array2){
            System.out.print(temp + " ");
        }

        int[] array3 = new int[]{9,1,5,8,3,7,4,6,2};
        ArraySort.selectSort(array3);
        System.out.println("\n选择排序：");
        for (int temp : array3){
            System.out.print(temp + " ");
        }

        int[] array4 = new int[]{9,1,5,8,3,7,4,6,2};
        ArraySort.insertSort(array4);
        System.out.println("\n插入排序：");
        for (int temp : array4){
            System.out.print(temp + " ");
        }

        int[] array5 = new int[]{9,1,5,8,3,7,4,6,2};
        ArraySort.shellSort(array5);
        System.out.println("\n希尔排序：");
        for (int temp : array5){
            System.out.print(temp + " ");
        }



    }
}
