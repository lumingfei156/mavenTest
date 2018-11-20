package com.maven.javaBean;

import com.maven.javaBean.Service.ImyStack;

public class MyStack implements ImyStack {
    private int top;//描述栈顶的位置,也就是链表尾的下标
    private Object[] elementData;//缓存数组
    private final static int DEFAULT_INITCACITY = 100;

    public MyStack(){
        this(DEFAULT_INITCACITY);
    }

    public MyStack(int initCapacity){
        if(initCapacity < 0 ) throw new IllegalArgumentException("初始化容量有误");
        elementData = new Object[initCapacity];
    }

    /**
     *
     * @param object 要插入的元素
     * @throws Exception
     * @description 压栈操作，通过在数组尾部插入元素，进行压栈
     */
    @Override
    public void push(Object object) throws Exception {
        try {
            if (top == elementData.length - 1) throw new IllegalArgumentException("栈已经满了");
            elementData[++top] = object;
        } catch (IllegalArgumentException e) {
            throw new Exception(e);
        } catch (Exception e){
            throw e;
        }
    }

    /**
     *
     * @return 被弹出的元素
     * @throws Exception
     * @description 弹栈操作，弹出一个缓存数组最后一个元素
     */
    @Override
    public Object pop() throws Exception {
        try {
            if(top == -1) throw new IllegalArgumentException("目前就是空栈，请不要进行弹栈操作");
            Object toReturn = elementData[top];
            elementData[top--] = null;
            return toReturn;
        } catch (IllegalArgumentException e) {
            throw new Exception(e);
        } catch (Exception e){
            throw e;
        }
    }

    public String toString(){
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("[ ");
        for (Object o : elementData){
            String temp = (String) o;
           stringBuilder.append( temp + " ");
       }
       stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
