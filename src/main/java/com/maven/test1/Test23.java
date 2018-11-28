package com.maven.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * lambda 表达式测试
 * @author lulu
 * @since 2018/11/28
 */
public class Test23 {
    static final String HELLO = "Hello ";
    public static void main(String[] args) {
        Test23 test23 = new Test23();
        //声明类型
        MathOperation add = (int a,int b) -> a + b;
        //不声明类型
        MathOperation sub = (a,b) -> a - b;
        //大括号有返回语句
        MathOperation multi = (a,b) -> {return a * b;};
        //没大括号也没有返回值
        MathOperation div = (a,b) -> a/b;

        //不用括号
        GreetingService greet1 = message -> System.out.println(HELLO + message);
        GreetingService greet2 = (message) -> System.out.println(HELLO + message);

        System.out.println(test23.operate(1,2,add));
        System.out.println(test23.operate(1,2,sub));
        System.out.println(test23.operate(1,2,multi));
        System.out.println(test23.operate(1,2,div));

        greet1.sayMessage("world1");
        greet2.sayMessage("world2");

        String[] ss = new String[]{"1","2","3"};
        List<String> str = Arrays.asList(ss);
        str.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("用lambda表达式");
        Consumer<String> consumer = (String temp) -> {
            System.out.println(temp);
        };
        str.forEach(consumer);

    }

    interface MathOperation{
        /**
         * 数学运算a和b
         * @param a 参数a
         * @param b 参数b
         * @return 运算后的值
         */
        int operation(int a,int b);
    }

    interface GreetingService{
        /**
         * 输出message
         * @param message 输出的信息
         */
        void sayMessage(String message);
    }

    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}
