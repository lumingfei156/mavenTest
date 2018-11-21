package com.maven.javaBean;


import com.maven.javaBean.Service.IchildShowTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 使用孩子表示法构建树形结构
 * @author lulu
 */
public class ChildShowTree<T> implements IchildShowTree<T>{
    /**
     * 存储节点链表的数组
     */
    private ChildTreeNode<T>[] nodes;

    /**
     * 缓存数组的最大长度
     */
    private static final int MAX_SIZE = 100;

    /**
     * 缓存数组的长度
     */
    private int treeSize;

    /**
     * 树的节点数
     */
    private int nodeNums = 0;

    public ChildShowTree(){}

    public ChildShowTree(T data){
        this(data,MAX_SIZE);
    }

    public ChildShowTree(ChildTreeNode<T> rootNode,int treeSize){
        this(rootNode.getData(),treeSize);
    }

    public ChildShowTree(T data,int treeSize){
        this.treeSize = treeSize;
        ChildTreeNode<T> rootNode = new ChildTreeNode<>(data);
        nodes = new ChildTreeNode[treeSize];
        nodes[0] = rootNode;
        nodeNums++;
    }

    /**
     * 添加子节点
     *
     * @param data   数据域
     * @param parent 双亲结点
     */
    @Override
    public void addNode(T data, ChildTreeNode<T> parent) {
        //将新的节点加到根节点下面，然后修改根节点的度和子节点链表的下标
        ChildTreeNode<T> addNode = new ChildTreeNode<>(data);
        for (int i = 0; i < treeSize;i++){
            if (nodes[i] == null){
                nodes[i] = addNode;
                parent.setDegree(parent.getDegree() + 1);
                parent.getChildList().add(i);
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
    public ChildTreeNode<T> getRoot() {
        return nodes[0];
    }

    /**
     * 获取双亲节点
     *
     * @param baby 子节点
     * @return 双亲节点
     */
    @Override
    public ChildTreeNode<T> getParent(ChildTreeNode<T> baby) {
        if (baby == null){
            throw new NoSuchElementException("要查找的节点不能为空");
        }
        //子节点的下标
        int babyIndex = -1;
        for (int i = 0;i < treeSize;i++){
            if (nodes[i] != null && nodes[i].equals(baby)){
                babyIndex = i;
                break;
            }
        }
        //获取到子节点的下标之后就遍历父节点的子节点链表，看有没有这个子节点，如果有就返回父节点下标
        if(babyIndex == -1){
            return null;
        }
        for (int i = 0;i < treeSize;i++){
            if (nodes[i] != null){
                if (nodes[i].getChildList().contains(babyIndex)){
                    return nodes[i];
                }
            }
        }
        return null;
    }

    /**
     * 获取子节点
     *
     * @param treeNode 传入节点
     * @return 子节点链表
     */
    @Override
    public List<ChildTreeNode<T>> getChild(ChildTreeNode<T> treeNode) {
        List<ChildTreeNode<T>> toReturn = new ArrayList<>();
        //获取节点的子节点链表直接返回就是了
        List<Integer> tempList = treeNode.getChildList();
        Iterator<Integer> iterator = tempList.iterator();
        while (iterator.hasNext()){
            toReturn.add(nodes[iterator.next()]);
        }
        return toReturn;
    }

    /**
     * 获取全部节点
     *
     * @return 返回节点链表
     */
    @Override
    public List<ChildTreeNode<T>> getTreeNode() {
        List<ChildTreeNode<T>> toReturn = new ArrayList<>();
        for (int i = 0;i < treeSize;i++){
            if (nodes[i] != null){
                toReturn.add(nodes[i]);
            }
        }
        return toReturn;
    }

    /**
     * 获取节点的位置SDS
     *
     * @param treeNode 要查找的节点
     * @return 返回位置
     */
    @Override
    public int getPos(ChildTreeNode<T> treeNode) {
        if (treeNode == null){
            throw new NoSuchElementException("传入的节点不能为空");
        }
        int toReturn = -1;
        for (int i = 0;i < treeSize;i++){
            if (nodes[i] != null && nodes[i].equals(treeNode)){
                toReturn = i;
                break;
            }
        }
        return toReturn;
    }

    /**
     * 获取树的度
     *
     * @return 度
     */
    @Override
    public int getDeepth() {
        int def = 0;
        if (nodeNums == 0){
            return def;
        }
        ++def;



        return 0;
    }
}
