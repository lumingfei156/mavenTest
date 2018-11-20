package com.maven.test1;

import com.maven.javaBean.UnboundStack;

public class Test14 {
    public static void main(String[] args) throws Exception {
        UnboundStack unboundStack = new UnboundStack(3);
        unboundStack.push("1");
        unboundStack.push("2");
        unboundStack.push("3");
        unboundStack.push("4");

        System.out.println(unboundStack.pop());
        System.out.println(unboundStack.display());
    }
}
