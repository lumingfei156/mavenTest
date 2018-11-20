package com.maven.javaBean;

import com.maven.javaBean.Service.IlinkedList;

public class LinkedListStack<E> implements IlinkedList<E>{
    private Node<E> header;//第一个节点


    public LinkedListStack(){ }

    public void push(E element){
        add(element);
    }

    public E pop(){
        return delete();
    }

    /**
     * @param element 要添加进去的对象
     * @description 每次添加对象都把节点放到链表头
     */
    @Override
    public void add(E element) {
        header = new Node<>(element,header);
    }

    /**
     * @return 返回被删除的节点
     * @description 每次删除方法被调用都去掉链表的头节点
     */
    @Override
    public E delete() {
        if(header == null) throw new IllegalArgumentException("当前是空栈");
        Node<E> returnNode = header;
        header = header.next;
        return returnNode.data;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        Node temp = header;
        while (temp != null){
            stringBuilder.append(temp.data + " ");
            temp = temp.next;
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data,Node<E> next){
            this.data = data;
            this.next = next;
        }

        public Node(E data){
            this.data = data;
        }
    }
}
