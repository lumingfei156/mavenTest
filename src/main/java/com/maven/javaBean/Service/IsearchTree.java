package com.maven.javaBean.Service;

import com.maven.javaBean.BrinaryNode;

/**
 * 二叉排序树接口
 * @author lulu
 * @since 2018/11/27
 */
public interface IsearchTree<T> {

    /**
     * 插入节点
     * @param data 数据域
     * @return 成功true，失败false
     */
    boolean addTreeNode(T data);

    /**
     * 查询某个数据域是否在二叉排序树中
     * @param data 要查询的数据域
     * @return 返回查出来的数据域
     */
    BrinaryNode<T> findTreeNode(T data);

}
