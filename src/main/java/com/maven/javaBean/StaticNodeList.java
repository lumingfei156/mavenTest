package com.maven.javaBean;

import com.maven.javaBean.Service.IstaticNodeList;

public class StaticNodeList<T> implements IstaticNodeList {
    private Node[] elementData = null;

    public StaticNodeList(){
        this(DEFAULT_SIZE);
    }

    public StaticNodeList(int initSize){
        if(initSize < 0) throw new IllegalArgumentException("初始化长度有问题");
        elementData = new Node[initSize];
        for(int i = 0;i < initSize - 1;++i){
            elementData[i] = new Node<T>(null,i + 1);
        }
        elementData[initSize - 1] = new Node<T>(null,0);
    }



    @Override
    public int length() {
//        遍历整个整个有用链表，直到遇到下标为0的元素
        int tempIndex = elementData[elementData.length - 1].getCur();
        int length = 0;
        while (tempIndex != 0){
            tempIndex = elementData[tempIndex].getCur();
            length++;
        }
        return length;
    }

    @Override
    public int getBackListFirstIndex() {
        return elementData[0].getCur();
    }

    @Override
    public int applySpaceFormBackUpList() {
        int firstBackUpIndex = this.getBackListFirstIndex();
        if(firstBackUpIndex != 0){
            elementData[0].setCur(elementData[firstBackUpIndex].getCur());
            return firstBackUpIndex;
        }
        return -1;
    }

    @Override
    public T increaseSpaceToBackupList(int index) {
        //将要数组放到备用链表的第一位
        int newBackNodeCur = elementData[0].getCur();
        T toReturn = (T) elementData[index].getData();
        elementData[0].setCur(elementData[index].getCur());
        elementData[index].setCur(newBackNodeCur);
        elementData[index].setData(null);
        return toReturn;
    }

    @Override
    public boolean insert(Object o) {
        int length = this.length();
        return insert(length,o);
    }

    /**
     *
     * @param i 插入的位置
     * @param o 插入的data
     * @return
     */
    @Override
    public boolean insert(int i, Object o) {
        if(i > this.length()) throw new IllegalArgumentException("插入位置有误！");
        int length = this.length();
        if(i >= length){
            i = length + 1;
        }
        if (i <= 0)
            i = 1;
        int newNodeIndex = this.applySpaceFormBackUpList();
        if(newNodeIndex > 0){
            int tempIndex = elementData[elementData.length - 1].getCur();
            for (int k = 1;k < i; k++){
                tempIndex = elementData[tempIndex].getCur();
            }
            Node newNode = new Node<T>((T)o,elementData[tempIndex].getCur());
            elementData[tempIndex].setCur(newNodeIndex);
            elementData[newNodeIndex] = newNode;
//            if(length == 0) elementData[elementData.length - 1].setCur(1);
        }
        return true;
    }

    @Override
    public T remove(int i) {
        if(i < 1 || i > DEFAULT_SIZE - 1) throw new IllegalArgumentException("删除的下标有误!");
        //修正i的位置
        int length = this.length();
        if( i > length ) i = length;
        int tempIndex = elementData[elementData.length - 1].getCur();
        //遍历数组获取要删除的下标的前一个元素
        for(int k = 1;k < i;k++ ){
            tempIndex = elementData[tempIndex].getCur();
        }
        Node toRemove = elementData[elementData[tempIndex].getCur()];
        elementData[tempIndex].setCur(toRemove.getCur());

        this.increaseSpaceToBackupList(elementData[tempIndex].getCur());
        return (T) toRemove.getData();
    }

    @Override
    public void removeAll() {
//        int firstIndex = elementData[0].getCur();
        while (elementData[0].getCur() !=  1){
            remove(length());
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(elementData[0] + " ");
        int tempIndex = elementData[elementData.length - 1].getCur();
        while (tempIndex != 0){
            sb.append(elementData[tempIndex] + " ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    class Node<T> {
        private T data;
        private int cur;

        public Node(T data,int cur){
            this.data = data;
            this.cur = cur;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getCur() {
            return cur;
        }

        public void setCur(int cur) {
            this.cur = cur;
        }

        @Override
        public String toString(){
            return this.getData() + " " + this.getCur() + " ";
        }
    }
}
