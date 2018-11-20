package com.maven.test1;

import com.maven.javaBean.BothStackShareMemory;

import java.util.Queue;

public class Test16 {
    public static void main(String[] args) {
        BothStackShareMemory<String> stack = new BothStackShareMemory<>();
        stack.push(1,"1");
        stack.push(1,"2");
        stack.push(1,"3");
        stack.push(1,"4");
        stack.pop(1);
        stack.push(2,"1");
        stack.push(2,"2");
        System.out.println(stack.display(1));
        System.out.println(stack.display(2));
    }
}
