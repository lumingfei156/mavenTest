package com.maven.test1;

import com.maven.javaBean.MyTree;
import com.maven.javaBean.Service.IbinaryTree;
import com.maven.javaBean.TreeNode;


/**
 * @author lulu
 */
public class Test19 {

    public static void main(String[] args) {
        TreeNode<String> parentNode = new TreeNode<>("0",-1);
        IbinaryTree<String> myTree = new MyTree<>(parentNode,10);

        TreeNode<String> temp = new TreeNode<>("1-1",myTree.getPos(parentNode));
        myTree.addNode(temp.getData(),parentNode);
        myTree.addNode("1-2",parentNode);
        myTree.addNode("1-3",parentNode);
        myTree.addNode("2-1",temp);

        System.out.println(myTree.getDeepth());

    }
}
