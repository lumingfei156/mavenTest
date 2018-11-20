package com.maven.javaBean;

public class BothStackShareMemory<E>{
    private Object[] elementData;//缓存数组
    private int stackSize;//栈长度
    private int top1;//第一个栈的栈顶下标
    private int top2;//第二个栈的栈顶下标
    private static final int DEFAULT_SIZE = 5;

    public BothStackShareMemory(){
        stackSize = DEFAULT_SIZE;
        elementData = new Object[stackSize];
        top1 = -1;
        top2 = stackSize;
    }

    /**
     * @param stackNum 第几个栈
     * @param element 要插入的元素
     * @throws Exception
     */
    public void push(int stackNum ,E element){
        if(top1 + 1 == top2) throw new IllegalArgumentException("栈满");
        if(stackNum == 1)
            elementData[++top1] = element;
        else
            elementData[--top2] = element;
    }


    public E pop(int stackNum){
        E toReturn = null;
        if (stackNum == 1){
            if(top1 == -1) throw new IllegalArgumentException("1栈为空");
            toReturn = (E) elementData[top1];
            elementData[top1--] = null;
            return toReturn;
        }else {
            if(top2 == stackSize) throw new IllegalArgumentException("2栈为空");
            toReturn = (E) elementData[top2];
            elementData[top2++] = null;
            return toReturn;
        }
    }

    public String display(int stackNum){
        StringBuilder sb = new StringBuilder("[ ");
        if(stackNum == 1){
            for (int i = top1;i > -1;i--){
                sb.append(elementData[i] + " ");
            }
        }else {
            for (int i = top2;i < stackSize; i++){
                sb.append(elementData[i] + " ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
