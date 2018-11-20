package com.maven.test1;

import com.maven.javaBean.LinkedListStack;

public class Test15 {

    public static void main(String[] args) {
        LinkedListStack<String> linkedListStack = new LinkedListStack<>();
        linkedListStack.push("1");
        linkedListStack.push("2");
        linkedListStack.push("3");
        linkedListStack.push("4");

        System.out.println(linkedListStack.toString());
    }
}
