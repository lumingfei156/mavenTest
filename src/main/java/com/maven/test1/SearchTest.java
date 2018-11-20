package com.maven.test1;

import java.util.Arrays;

public class SearchTest {

    public static void main(String[] args) {
        Integer[] k = {21,11,15,16,18,20,21,23};
        SearchTest.binarysearchKey(k,17);
//        System.out.println(Arrays.binarySearch(k,17));
    }

    public static int binarysearchKey(Object[] array, int targetNum) {

        //Object[] array = temp.clone();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        int targetindex = 0;
        int left = 0,right = 0;
        for (right = array.length-1; left!=right;) {
            int midIndex = (right + left)/2;
            int mid = (right - left);
            int midValue = (Integer) array[midIndex];
            if (targetNum == midValue) {
                return midIndex;
            }
            if(targetNum > midValue){
                left = midIndex;
            }else{
                right = midIndex;
            }

            if (mid <=1) {
                break;
            }
        }
        int rightnum = ((Integer) array[right]).intValue();
        int leftnum = ((Integer) array[left]).intValue();
//        int ret =  Math.abs((rightnum - leftnum)/2) > Math.abs(rightnum -targetNum) ? rightnum : leftnum;
        int ret =  Math.abs(left - targetNum) > Math.abs(rightnum -targetNum) ? rightnum : leftnum;
        System.out.println("和要查找的数："+targetNum+ "最接近的数：" + ret);
        return ret;
    }

}
