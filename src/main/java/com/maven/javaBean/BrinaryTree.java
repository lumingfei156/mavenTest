package com.maven.javaBean;

import com.maven.javaBean.Service.IbrinaryTree;


import java.util.LinkedList;
import java.util.List;

/**
 * @author lulu
 * 二叉树实现类
 */
public class BrinaryTree<T> implements IbrinaryTree<T>{
    /**
     * 二叉树节点链表
     */
    private List<BrinaryNode<T>> nodeList;

    String[] str;

    int count = 0;

    private BrinaryNode<Integer> root;



    /**
     * 通过数组创建二叉树
     *
     * @param t 数组
     * @return 二叉树
     */
    @Override
    public List<BrinaryNode<T>> createBiTree(T[] t) {
        nodeList = new LinkedList<>();
        BrinaryNode<T> temp = null;
        //将数组元素添加进二叉树
        for (int i = 0;i < t.length;i++){
            temp = new BrinaryNode<T>(t[i]);
            nodeList.add(temp);
        }

        return null;
    }

    /**
     * 不知道干嘛的，等会看下实现
     *
     * @return 777777
     */
    @Override
    public BrinaryNode<T> createBiTree() {
        return null;
    }

    /**
     * 前序遍历
     *
     * @param root 1
     */
    @Override
    public void preOrderTraverse(BrinaryNode<Integer> root) {

    }

    /**
     * 中序遍历
     *
     * @param root 1
     */
    @Override
    public void inOrderTraverse(BrinaryNode<Integer> root) {

    }

    /**
     * 后序遍历
     *
     * @param root 1
     */
    @Override
    public void postOrderTraverse(BrinaryNode<Integer> root) {

    }


}
