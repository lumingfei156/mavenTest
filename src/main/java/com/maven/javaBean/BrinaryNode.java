package com.maven.javaBean;

/**
 * @author lulu
 * 二叉树节点类
 */
public class BrinaryNode<T> {
    /**
     * 数据域
     */
    private T data;

    /**
     * 左孩子
     */
    private BrinaryNode<T> lChild;

    /**
     * 右孩子
     */
    private BrinaryNode<T> rChild;

    public BrinaryNode(){
        this.data = null;
        this.lChild = null;
        this.rChild = null;
    }

    public BrinaryNode(T data){
        this.data = data;
    }

    public BrinaryNode(T data,BrinaryNode<T> lChild,BrinaryNode<T> rChild){
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BrinaryNode<T> getlChild() {
        return lChild;
    }

    public void setlChild(BrinaryNode<T> lChild) {
        this.lChild = lChild;
    }

    public BrinaryNode<T> getrChild() {
        return rChild;
    }

    public void setrChild(BrinaryNode<T> rChild) {
        this.rChild = rChild;
    }
}
