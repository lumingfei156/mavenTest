package com.maven.test1;

import com.maven.javaBean.BrinaryNode;
import com.maven.javaBean.SearchTree;
import com.maven.javaBean.Service.IsearchTree;

/**
 * 二叉排序树测试类
 * @author lulu
 * @since 2018/11/27
 */
public class Test22 {

    public static void main(String[] args) {
        IsearchTree<Integer> searchTree = new SearchTree<>();
        searchTree.addTreeNode(5);
        searchTree.addTreeNode(2);
        searchTree.addTreeNode(8);
        searchTree.addTreeNode(1);
        searchTree.addTreeNode(3);
        BrinaryNode<Integer> findNode = searchTree.findTreeNode(100);
        System.out.println(findNode.getData());
    }
}
