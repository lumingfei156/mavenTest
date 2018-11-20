package com.maven.test1;


import com.maven.javaBean.LinkQueue;
import com.maven.javaBean.Service.ImyQueue;

/**
 * @author lulu
 */
public class Test18 {

    public static void main(String[] args) {
        ImyQueue<String> linkQueue = new LinkQueue<>();
        linkQueue.add("1");
        linkQueue.add("2");
        linkQueue.add("3");
        linkQueue.add("4");

        linkQueue.poll();
        linkQueue.poll();
        linkQueue.add("5");

        System.out.println(linkQueue);

    }
}
