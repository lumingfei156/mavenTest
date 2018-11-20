package com.maven.javaBean;

import com.maven.javaBean.Service.ImyQueue;

import java.util.NoSuchElementException;


public class ArrayQueue<T> implements ImyQueue<T> {
    /**
     * 缓存数组
     */
    private Object[] elementData;

    /**
     * 队列长度
     */
    private int size;

    /**
     * 队列头下标和队列尾下一个元素下标
     */
    private int front,rear;

    /**
     * 默认长度
     */
    private final static int DEFAULT_SIZE = 5;

    public ArrayQueue(){
        this(DEFAULT_SIZE);
    }

    public ArrayQueue(int initSize){
        if(initSize < 0){
            throw new IllegalArgumentException("初始化长度有误");
        }

        elementData = new Object[initSize];
        size = 0;
        front = rear = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean add(T data) {
        int oldLength = elementData.length;
        //先判断是否需要扩容
        if((rear + 1) % oldLength == front) {
            ensureCapacity(oldLength * 2 + 1);
        }
//        将元素添加到现在rear的位置，然后改变rear的位置
        elementData[rear] = data;
        rear = (rear + 1) % elementData.length;
        size++;
        return true;
    }

    @Override
    public boolean offer(T data) {
        if(data == null) {
            throw new IllegalArgumentException("插入的元素不能为null");
        }
        if((rear + 1) % elementData.length == front ) {
            throw new IllegalArgumentException("队列已经满了");
        }
        elementData[rear] = data;
        rear = (rear + 1) % elementData.length;
        size++;
        return  true;
    }

    @Override
    public T peek() {
        return (T) elementData[front];
    }

    @Override
    public T element() {
        if(this.isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return (T) elementData[front];
    }

    @Override
    public T poll() {
        T toReturn = (T) elementData[front];
        elementData[front] = null;
        this.front = (front + 1) % elementData.length;
        size--;
        return toReturn;
    }

    @Override
    public T remove() {
        if(isEmpty()) {
            throw new NoSuchElementException("抱歉队列为空，不能删除");
        }
        return poll();
    }

    @Override
    public void clearQueue() {
        int length = elementData.length;
        for(int i = front;i != rear;i = (i + 1) % length){
            elementData[i] = null;
        }
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    private void ensureCapacity(int capacity){
        Object[] oldElementData = elementData;
        Object[] newElementData = new Object[capacity];
        int j = 0;
        //通过遍历，把循环队列排会一条直线
        for(int i = front;i != rear;i = (i + 1)%oldElementData.length){
            newElementData[j++] = oldElementData[i];
        }
        elementData = newElementData;
        front = 0;
        rear = j;
    }

    @Override
    public String toString(){
        int length = elementData.length;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = front;i != rear;i = (i + 1) % length){
            sb.append(elementData[i] + " ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
