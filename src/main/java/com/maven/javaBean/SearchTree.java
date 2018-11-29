package com.maven.javaBean;

import com.maven.javaBean.Service.IsearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉排序树的实现类
 * @author lulu
 * @since 2018/11/27
 */
public class SearchTree<T extends Comparable<T>> implements IsearchTree<T> {

    /**
     * 根节点
     */
    private BrinaryNode<T> root;
    /**
     * 长度
     */
    private int size;

    /**
     * 用于各种遍历的返回数组
     */
    private static List<Integer> travers = null;

    public SearchTree(){}

    public SearchTree(BrinaryNode<T> root){
        this.root = root;
    }

    /**
     * 插入节点
     *
     * @param data 数据域
     * @return 成功true，失败false
     */
    @Override
    public boolean addTreeNode(T data) {
//        boolean toReturn = false;
        //构造要插入的节点
        BrinaryNode<T> newNode = new BrinaryNode<>(data);
        //构建一个用于循环插入的树根节点，首先从二叉排序树的根节点开始
        BrinaryNode<T> currentNode = root;
        if (root == null){
            root = newNode;
            ++size;
            System.out.println("数据成功插入到二叉树！");
            return true;
        }

        while (true){
            /*
             *分为三种情况
             * 1 如果插入的值大于根节点，就放到左子树
             * 2 如果插入的值小于根节点，就放到右子树
             * 3 如果插入的值和本节点一样，就抛错，不让他插入
             */
            if (currentNode.getData().compareTo(data) < 0){
                //插入节点的数据域比当前节点的数据域大，就放到右子树
                if (currentNode.getrChild() == null){
                    currentNode.setrChild(newNode);
                    newNode.setParent(currentNode);
                    ++size;
                    System.out.println("数据成功插入二叉树！");
                    return true;
                }else {
                    currentNode = currentNode.getrChild();
                }

            }else if (currentNode.getData().compareTo(data) > 0){
                //插入的数据比当前节点小，就放到左子树
                if (currentNode.getlChild() == null){
                    currentNode.setlChild(newNode);
                    newNode.setParent(currentNode);
                    ++size;
                    System.out.println("数据成功插入二叉树！");
                    return true;
                }else {
                    currentNode = currentNode.getlChild();
                }
            }else {
                throw new IllegalArgumentException("插入的数据域已经存在二叉排序树中，不能插入！");
            }
        }
    }

    /**
     * 查询某个数据域是否在二叉排序树中
     * @param data 要查询的数据域
     * @return 返回查出来的数据域
     */
    @Override
    public BrinaryNode<T> findTreeNode(T data) {
        BrinaryNode<T> toReturn = null;
        if (this.size == 0){
            throw new IllegalArgumentException("当前树为空树!");
        }
        BrinaryNode<T> currentNode = root;
        while (currentNode != null){
            if (data.compareTo(currentNode.getData()) < 0){
                //如果数据比当前节点小，就往左子树方面遍历
                currentNode = currentNode.getlChild();
            }else if (data.compareTo(currentNode.getData()) > 0){
                //如果数据比当前节点大，就往右边遍历
                currentNode = currentNode.getrChild();
            }else {
                //如果数据等于当前节点，就直接返回当前节点
                return currentNode;
            }
        }
        return toReturn;
    }

    /**
     * 二叉树的前序遍历实现(递归实现)
     * @param rootNode 要遍历的二叉树的根节点
     * @return 数据域的hashCode组成的整型数组
     */
    public static List<Integer> preOrderTraverse(BrinaryNode rootNode){
        travers = new ArrayList<>();
        //方法递归
        actPreOrderTraverse(rootNode);
        return travers;
    }

    /**
     * 用栈和循环实现前序遍历
     * @param rootNode 根节点
     * @param t 用于区分递归方法前序遍历
     * @return ddd
     */
    public static List<Integer> preOrderTraverse(BrinaryNode rootNode,boolean t){
        travers = new ArrayList<>();
        //利用栈先进后出的特性实现
        Stack<BrinaryNode> stack = new Stack<>();
        BrinaryNode currentNode = rootNode;

        while (currentNode != null){
            //有节点进来就压栈，但关键是出栈的顺序
            stack.push(currentNode);

            while (!stack.isEmpty()){
                //将根节点出栈，然后再把右左孩子进栈，这样就达到了左孩子整棵树都出栈了再到有孩子出栈
                currentNode = stack.pop();
                travers.add(currentNode.getData().hashCode());

                if (currentNode.getrChild() != null){
                    stack.push(currentNode.getrChild());
                }
                if (currentNode.getlChild() != null){
                    stack.push(currentNode.getlChild());
                }
            }
            //主动置空，不然currentNode一直为真
            currentNode = null;
        }
        return travers;
    }

    /**
     * 二叉树的中序遍历实现(递归实现)
     * @param rootNode 要遍历的二叉树的根节点
     * @return 数据域的hashCode组成的整型数组
     */
    public static List<Integer> inOrderTraverse(BrinaryNode rootNode){
        travers = new ArrayList<>();
        //方法递归
        actInOrderTraverse(rootNode);
        return travers;
    }

    /**
     * 用栈和循环实现中序遍历
     * @param rootNode 根节点
     * @param t 用于区分递归方法中序遍历
     * @return ddd
     */
    public static List<Integer> inOrderTraverse(BrinaryNode rootNode,boolean t){
        travers = new ArrayList<>();
        //利用栈先进后出的特性实现
        Stack<BrinaryNode> stack = new Stack<>();
        BrinaryNode currentNode = rootNode;
        while (!stack.isEmpty() || currentNode != null){
            //先把节点的左孩子全都添加到栈中，然后通过出栈改变currentNode的值
            while (currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.getlChild();
            }
            if (!stack.isEmpty()){
                //把树的根节点出栈，然后改变currentNode的值，这时候会回到上一个while循环，这时候就会把右节点也添加到栈中
                currentNode = stack.pop();
                travers.add(currentNode.getData().hashCode());
                currentNode = currentNode.getrChild();
            }
        }
        return travers;
    }

    /**
     * 二叉树的后序遍历实现(递归实现)
     * @param rootNode 要遍历的二叉树的根节点
     * @return 数据域的hashCode组成的整型数组
     */
    public static List<Integer> postOrderTraverse(BrinaryNode rootNode){
        travers = new ArrayList<>();
        //方法递归
        actPostOrderTraverse(rootNode);
        return travers;
    }

    /**
     * 用栈和循环实现二叉排序树的后序遍历
     * @param rootNode 要遍历的二叉树的根节点
     * @return 数据域的hashCode组成的整型数组
     */
    public static List<Integer> postOrderTraverse(BrinaryNode rootNode,boolean t){
        travers = new ArrayList<>();
        //想不出来，好烦！！！先不写了
        if(rootNode != null){
            while (true){

            }
        }
        return travers;
    }

    /**
     * 前序遍历递归实现
     * @param tempNode 要遍历的根节点
     */
    private static void actPreOrderTraverse(BrinaryNode tempNode){

        if (tempNode != null){
            travers.add(tempNode.getData().hashCode());
            if (tempNode.getlChild() != null){
                actPreOrderTraverse(tempNode.getlChild());
            }
            if  (tempNode.getrChild() != null){
                actPreOrderTraverse(tempNode.getrChild());
            }
        }
    }

    /**
     * 中序遍历递归实现
     * @param tempNode 要遍历的根节点
     */
    private static void actInOrderTraverse(BrinaryNode tempNode){

        if (tempNode != null){

            if (tempNode.getlChild() != null){
                actInOrderTraverse(tempNode.getlChild());
            }
            travers.add(tempNode.getData().hashCode());
            if  (tempNode.getrChild() != null){
                actInOrderTraverse(tempNode.getrChild());
            }
        }
    }

    /**
     * 后序遍历递归实现
     * @param tempNode 要遍历的根节点
     */
    private static void actPostOrderTraverse(BrinaryNode tempNode){

        if (tempNode != null){

            if (tempNode.getlChild() != null){
                actPostOrderTraverse(tempNode.getlChild());
            }
            if  (tempNode.getrChild() != null){
                actPostOrderTraverse(tempNode.getrChild());
            }
            travers.add(tempNode.getData().hashCode());
        }
    }

    public BrinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BrinaryNode<T> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
