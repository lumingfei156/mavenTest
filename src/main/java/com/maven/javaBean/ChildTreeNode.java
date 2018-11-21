package com.maven.javaBean;

import java.util.LinkedList;

/**
 * @author lulu
 * @param <T>
 */
public class ChildTreeNode<T> {
    /**
     * 数据域
     */
    private T data;

    /**
     * 度域
     */
    private int degree;

    /**
     * 孩子节点链表,存储了孩子节点在缓存数组的下标
     */
    private LinkedList<Integer> childList;


    public ChildTreeNode(){ }

    public ChildTreeNode(T data){
        this.data = data;
        this.degree = 0;
        this.childList = new LinkedList<>();
    }

    public ChildTreeNode(T data,int degree){
        this.data = data;
        this.degree = degree;
        this.childList = new LinkedList<>();
    }

    public ChildTreeNode(T data,int degree,LinkedList<Integer> childList){
        this.data = data;
        this.degree = degree;
        this.childList = childList;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public LinkedList<Integer> getChildList() {
        return childList;
    }

    public void setChildList(LinkedList<Integer> childList) {
        this.childList = childList;
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object == null){
            return false;
        }

        if(this.getClass() != object.getClass()){
            return false;
        }
        //先比较data是否相等，如果相等在比较存储子节点的链表是否相等
        ChildTreeNode<T> toCompare = (ChildTreeNode<T>) object;
        if(this.data == null){
            if (toCompare.data != null){
                return false;
            }
        }else {
            if(!this.data.equals(toCompare.data)) {
                return false;
            }
        }

        if (!this.childList.equals(toCompare.childList)){
            return false;
        }
        return true;
    }


    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime * result +( ( this.data == null) ? 0 : this.data.hashCode() );
        return result * prime + this.childList.hashCode();
    }

}
