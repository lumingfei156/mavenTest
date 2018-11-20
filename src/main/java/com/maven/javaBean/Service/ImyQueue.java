package com.maven.javaBean.Service;

public interface ImyQueue<T> {
    /**
     * 返回队列长度
     * @return
     */
    int size();

    boolean isEmpty();//判断是否为空

    /**
     * 入队
     * @param data 要入队的元素
     * @return 返回true 或 false
     */
    boolean add(T data );

    /**
     * 通过抛出异常来表示入队失败,而且入队的时候并不会进行扩容操作
     * @param data
     * @return
     */
    boolean offer(T data);

    /**
     * 返回队头元素，不执行删除方法，如果队列为空，就返回null
     * @return
     */
    T peek();

    /**
     * 返回队头元素，不执行删除方法，如果队列为空，就抛异常
     * @return
     */
    T element();

    /**
     * 出队,如果队列为空，就返回null
     * @return
     */
    T poll();

    /**
     * 出队，如果队列为空，就抛异常
     * @return
     */
    T remove();

    /**
     * 清空队列
     */
    void clearQueue();

}
