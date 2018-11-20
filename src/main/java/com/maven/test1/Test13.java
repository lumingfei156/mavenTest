package com.maven.test1;

import com.maven.javaBean.MyStack;

public class Test13 {

    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack();
        stack.push("hello");
        stack.push("world");
        stack.push("你");
        stack.push("好");
        stack.push("世");
        stack.push("界");

        System.out.println((String)stack.pop());
        System.out.println((String)stack.pop());
        System.out.println((String)stack.pop());
        System.out.println((String)stack.pop());
        System.out.println((String)stack.pop());
        System.out.println((String)stack.pop());
    }
}
