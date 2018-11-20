package com.maven.javaBean;

import com.maven.javaBean.Service.ImyQueue;

/**
 * @author lulu
 * @param <T>
 */
public class LinkQueue<T> implements ImyQueue {
    /**
     * 队列头节点和队列尾节点,当两个都为null时，队列为空
     */
    private Node<T> front;
    private Node<T> rear;

    /**
     * 队列的长度
     */
    private int size;

    /**
     * 最大长度，当offer方法会用到
     */
    private static final int MAX_SIZE = 10;

    public LinkQueue(){
        this.size = 0;
        this.front = this.rear = null;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public boolean add(Object data) {
        Node<T> newNode = new Node(data,null);
        final Node oldRear = this.rear;
        //先看下是不是空队列
        if(this.front == null){
            this.front = newNode;
        }else {
            oldRear.next = newNode;
        }
        rear = newNode;
        size++;
        return true;
    }

    @Override
    public boolean offer(Object data) {
        if(this.front == null) {
            throw new IllegalArgumentException("插入的元素不能为空");
        }
        if(size >= MAX_SIZE){
            throw new IllegalArgumentException("队列已经满了，不能再插入元素");
        }
        return add(data);
    }

    @Override
    public Object peek() {
        if(this.front == null){
            return null;
        }else {
            return this.front.data;
        }
    }

    @Override
    public Object element() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return this.front.data;
    }

    @Override
    public Object poll() {
        if(isEmpty()){
            return null;
        }
        T toReturn = this.front.data;
        Node oldFront = this.front;
        this.front = oldFront.next;
        if(this.front == null){
            this.rear = null;
        }
        oldFront = null;
        size--;
        return toReturn;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public void clearQueue() {

    }

    class Node<T>{
        private T data;
        private Node next;

        public Node(){}

        public Node(T data){
            this(data,null);
        }

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
