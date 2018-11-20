package com.maven.test1;

public class Test02 {
    private int count;

    public static void main(String[] args) {
//        Test02 t = new Test02(11);
//        System.out.println(t.count);

        String src = ",19991212";
        String pattern = ",";

        int count = 0;
        int tempIndex = src.indexOf(pattern);
        while (tempIndex > 0){
            count++;
            tempIndex = src.indexOf(pattern,tempIndex+1);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+count);
    }

    public Test02(int ss){
        this.count = ss;
    }
}
