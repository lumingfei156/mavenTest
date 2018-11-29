package com.maven.test1;

import com.maven.javaBean.BrinaryNode;
import com.maven.javaBean.SearchTree;

/**
 * 二叉排序树测试类
 * @author lulu
 * @since 2018/11/27
 */
public class Test22 {

    public static void main(String[] args) {
        SearchTree<Integer> searchTree = new SearchTree<>();
        searchTree.addTreeNode(5);
        searchTree.addTreeNode(2);
        searchTree.addTreeNode(8);
        searchTree.addTreeNode(1);
        searchTree.addTreeNode(3);
        BrinaryNode<Integer> findNode = searchTree.findTreeNode(5);
        System.out.println(findNode.getData());
        System.out.println("前序遍历：");
        System.out.println(SearchTree.preOrderTraverse(searchTree.getRoot(),false));
        System.out.println("中序遍历：");
        System.out.println(SearchTree.inOrderTraverse(searchTree.getRoot(),false));
        System.out.println("后序遍历：");
        System.out.println(SearchTree.postOrderTraverse(searchTree.getRoot()));
    }
}
