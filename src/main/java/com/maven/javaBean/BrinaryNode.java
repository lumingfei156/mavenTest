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
     * 父节点
     */
    private BrinaryNode<T> parent;

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
        this.parent = null;
    }

    public BrinaryNode(T data){
        this.data = data;
    }

    public BrinaryNode(T data,BrinaryNode<T> lChild,BrinaryNode<T> rChild){
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public BrinaryNode(T data,BrinaryNode<T> lChild,BrinaryNode<T> rChild,BrinaryNode<T> parent){
        this(data,lChild,rChild);
        this.parent = parent;
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

    public BrinaryNode<T> getParent() {
        return parent;
    }

    public void setParent(BrinaryNode<T> parent) {
        this.parent = parent;
    }
}
