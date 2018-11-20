package com.maven.javaBean.Service;

public interface IstaticNodeList<T> {
    int DEFAULT_SIZE = 1000;//数组的默认长度

    int length();//获取静态链表的长度
    int getBackListFirstIndex();//获取备用链表的首结点
    int applySpaceFormBackUpList();//从备用链表中申请一个结点
    T increaseSpaceToBackupList(int index);//将空间回收到备用链表
    boolean insert(T t);//在末尾插入一个元素
    boolean insert(int index,T t);//在某个位置添加一个元素
    T remove(int i);//删除某个下标的元素
    void removeAll();//删除所有元素
}
