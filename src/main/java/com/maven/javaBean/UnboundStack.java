package com.maven.javaBean;

import com.maven.javaBean.Service.ImyStack;

public class UnboundStack implements ImyStack {
    private Object[] elementData;
    private int top = -1;
    private final static int DEFAULT_SIZE = 100;

    public UnboundStack(){
        this(DEFAULT_SIZE);
    }

    public UnboundStack(int initCapacity){
        if(initCapacity < 0) throw new IllegalArgumentException("初始化容量不能小于零");
        elementData = new Object[initCapacity];
    }



    @Override
    public void push(Object object) throws Exception {
        if (top > (elementData.length * 3/4 - 1) ){
            enLarge();
        }
        elementData[++top] = object;
    }

    @Override
    public Object pop() throws Exception {
        if(top == -1) throw new IllegalArgumentException("已经是空栈了");
        Object toReturn = elementData[top];
        elementData[top--] = null;
        return toReturn;
    }

    /**
     * 扩容函数，将数组扩大到原来的1.5倍
     */
    public void enLarge(){
        int oldLength = elementData.length;
        int newLength;
        if(oldLength << 2 == 0)
            newLength = oldLength + 1;
        else
            newLength = oldLength + (oldLength << 1);
        Object[] newElementData = new Object[newLength];
        System.arraycopy(elementData,0,newElementData,0,elementData.length);
        for (int i = 0;i < elementData.length;i++){
            elementData[i] = null;
        }
        elementData = newElementData;
    }

    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0;i < elementData.length;i++){
            sb.append(elementData[i] + " ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
