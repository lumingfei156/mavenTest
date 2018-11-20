package com.maven.javaBean;

/**
 * @author lulu
 */
public class TreeNode<T> {
    /**
     * 数据
     */
    private T data;

    /**
     * 双亲节点
     */
    private int parent;

    public TreeNode(){ }

    public TreeNode(T data){
        this.data = data;
    }

    public TreeNode(T data,int parent){
        this.data = data;
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    /**
     * 31 + data的hashCode 作为一个临时值，然后用 临时值 * 31 + 上双亲节点 , 就是要返回的hashCode
     * @return 节点的hashCode
     */
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ( (data == null) ? 0 : data.hashCode() );
        return result * prime + parent;
    }

    @Override
    public boolean equals(Object object){
        //判断内存地址是否相等
        if(object == this){
            return true;
        }
        //判断object是否为空
        if(object == null){
            return false;
        }
        //判断object是否和this是同一类
        if(this.getClass() != object.getClass()){
            return false;
        }
        TreeNode newNode = (TreeNode) object;
//        先判断data和newNode是否相等,然后再判断两者的parent是否相等
        if(this.data == null){
            if(newNode.data != null){
                return false;
            }
        }else {
            if(!this.data.equals(newNode.data)){
                return false;
            }
        }
        if(this.parent != newNode.parent){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "TreeNode [ data : " + this.data + " ,parent : " + this.parent + " ]";
    }
}
