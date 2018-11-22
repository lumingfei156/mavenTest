package com.maven.javaBean.Service;

import com.maven.javaBean.TreeNode;

import java.util.List;

/**
 * @author lulu
 * @param <T>
 */
public interface ITree<T> {
    /**
     * 添加子节点
     * @param data 数据域
     * @param parent 双亲结点
     */
    void addNode(T data, TreeNode<T> parent);

    /**
     * 获取根节点
     * @return 根节点
     */
    TreeNode<T> getRoot();

    /**
     * 获取双亲节点
     * @param baby 子节点
     * @return 双亲节点
     */
    TreeNode<T> getParent(TreeNode<T> baby);

    /**
     * 获取子节点
     * @param treeNode 传入节点
     * @return 子节点链表
     */
    List<TreeNode<T>> getChild(TreeNode<T> treeNode);

    /**
     * 获取全部节点
     * @return 返回节点链表
     */
    List<TreeNode<T>> getTreeNode();

    /**
     * 获取节点的位置SDS
     * @param treeNode 要查找的节点
     * @return 返回位置
     */
    int getPos(TreeNode<T> treeNode);

    /**
     * 获取树的度
     * @return 度
     */
    int getDeepth();
}
