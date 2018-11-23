package com.maven.javaBean.Service;

import com.maven.javaBean.BrinaryNode;

import java.util.List;


/**
 * @author lulu
 * 二叉树接口类
 */
public interface IbrinaryTree<T> {

    /**
     * 通过数组创建二叉树
     * @param t 数组
     * @return 二叉树
     */
    List<BrinaryNode<T>> createBiTree(T[] t);

    /**
     * 不知道干嘛的，等会看下实现
     * @return 777777
     */
    BrinaryNode<T> createBiTree();

    /**
     * 前序遍历
     * @param root 1
     */
    void preOrderTraverse(BrinaryNode<Integer> root);

    /**
     * 中序遍历
     * @param root 1
     */
    void inOrderTraverse(BrinaryNode<Integer> root);

    /**
     * 后序遍历
     * @param root 1
     */
    void postOrderTraverse(BrinaryNode<Integer> root);

}
