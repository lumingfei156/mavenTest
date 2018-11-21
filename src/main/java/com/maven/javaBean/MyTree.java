package com.maven.javaBean;

import com.maven.javaBean.Service.IbinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author lulu
 */
public class MyTree<T> implements IbinaryTree<T> {
    /**
     * 树节点数组
     */
    private TreeNode<T>[] nodes;

    /**
     * 最大节点数
     */
    private static final int MAX_SIZE = 100;

    /**
     * 树的最大节点数
     */
    private int treeSize;

    /**
     * 节点数
     */
    private int nodeNums = 0;


    /**
     * 根据根节点来创建树
     * @param data 根节点元素
     */
    public MyTree(T data){
        this(data,MAX_SIZE);
    }

    /**
     * 根据根节点和最大节点数来创建树
     * @param data 根节点元素
     * @param treeSize 最大节点数
     */
    public MyTree(T data,int treeSize){
        this.treeSize = treeSize;
        nodes = new TreeNode[treeSize];
        nodes[0] = new TreeNode<>(data,-1);
        ++nodeNums;
    }

    public MyTree(TreeNode<T> rootNode,int treeSize){
        this(rootNode.getData(),treeSize);
    }

    /**
     * 添加子节点
     *
     * @param data   数据域
     * @param parent 双亲结点
     */
    @Override
    public void addNode(T data, TreeNode<T> parent) {
        if(nodeNums == treeSize){
            throw new IllegalArgumentException("树已满");
        }
        int parentIndex = this.getPos(parent);
        TreeNode<T> newTreeNode = new TreeNode<>(data,parentIndex);
        for (int i = 0;i < treeSize;++i){
            if(nodes[i] == null){
                nodes[i] = newTreeNode;
                ++nodeNums;
                break;
            }
        }
    }

    /**
     * 获取根节点
     *
     * @return 根节点
     */
    @Override
    public TreeNode<T> getRoot() {
        if(nodeNums == 0) {
            throw new NoSuchElementException("树为空"); }
        return nodes[0];
    }

    /**
     * 获取双亲节点
     *
     * @param baby 子节点
     * @return 双亲节点
     */
    @Override
    public TreeNode<T> getParent(TreeNode<T> baby) {
        if (baby.equals(nodes[0])){
            throw new NoSuchElementException("该节点为根节点，没有双亲节点");
        }
        return nodes[baby.getParent()];
    }

    /**
     * 获取子节点
     *
     * @param treeNode 传入节点
     * @return 子节点链表
     */
    @Override
    public List<TreeNode<T>> getChild(TreeNode<T> treeNode) {
        List<TreeNode<T>> returnList = new ArrayList<>();
        int parentIndex = this.getPos(treeNode);
        for (int i = 0;i < treeSize;++i){
            if(nodes[i] != null && nodes[i].getParent() == parentIndex){
                returnList.add(nodes[i]);
            }
        }
        return returnList;
    }

    /**
     * 获取全部节点
     *
     * @return 返回节点链表
     */
    @Override
    public List<TreeNode<T>> getTreeNode() {
        List<TreeNode<T>> returnList = new ArrayList<>();
        for (int i = 0;i < treeSize;i++){
            if (nodes[i] != null){
                returnList.add(nodes[i]);
            }
        }
        return returnList;
    }

    /**
     * 获取节点的位置SDS
     *
     * @param treeNode 要查找的节点
     * @return 返回位置
     */
    @Override
    public int getPos(TreeNode<T> treeNode) {
        if(nodeNums == 0){
            throw new NoSuchElementException("树为空");
        }
        for(int i = 0;i < treeSize;i++){
            if(nodes[i].equals(treeNode)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取树的度
     *
     * @return 度
     */
    @Override
    public int getDeepth() {
        //从数组的第一个节点开始取，获取他的父节点，如果父节点存在就继续获取，知道获取到根节点
        if(nodeNums == 0){
            return 0;
        }
        //设定一个临时的深度最大值用于比较每个节点的最大深度
        int max = 1;
        TreeNode<T> tempNode = null;
        for (int i = 0;i < treeSize;++i){
            //设定一个默认的的深度1
            int def = 1;
            if(nodes[i] != null){
                tempNode = nodes[i];
                while (tempNode.getParent() != -1){
                    tempNode = nodes[tempNode.getParent()];
                    ++def;
                }
            }
            if (max < def){
                max = def;
            }
        }
        return max;
    }
}
