package com.maven.javaBean.Service;

//静态链表接口
interface StaticLinkListable<T> {


    int Length();//静态链表长度

    int getBackupListFirstIndex();//获取当前备用链表的首结点地址

    T increaseSpaceToBackupList(int k);//将空闲空间回收至备用链表

    boolean insert(T element);//尾插

    boolean insert(int i, T element);//在第i个位置插入元素element

    T remove(int i);//删除表中第i个位置的元素


    void removeAll();//删除表中所有元素
}