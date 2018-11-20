package com.maven.test1;

import com.maven.javaBean.ArrayQueue;
import com.maven.javaBean.Service.ImyQueue;

/**
 * @author lulu
 */
public class Test17 {

    public static void main(String[] args) {
        ImyQueue<String> queue = new ArrayQueue<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.poll();
        queue.poll();
        queue.offer("5");
        queue.offer("6");
        System.out.println(queue.toString());
    }
}
