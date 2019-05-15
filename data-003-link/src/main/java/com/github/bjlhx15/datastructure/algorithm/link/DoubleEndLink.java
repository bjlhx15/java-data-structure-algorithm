package com.github.bjlhx15.datastructure.algorithm.link;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/22 上午10:53
 */
public class DoubleEndLink<E> {
    private Node<E> header;//指向链表第一个结点
    private Node<E> tail;  //指向链表最后一个节点

    public DoubleEndLink() {
        header=new Node<>(null,null);
        tail=null;
    }
    //最后位置添加
    public void addNode(Node node){
        if(isEmpty()){
            header.next=node;//只有头节点，需要将新添加的指向下一个
        }else{
            tail.next=node; //将添加加点指向 最后一个的next
        }
        tail=node;//将需添加的节点指向 tail
    }

    //判空
    public boolean isEmpty(){
        return (header.next == null);
    }

    public int length(){
        int length=0;
        Node<E> node = this.header;
        while (node.next!=null){
            length++;
            node=node.next;
        }
        return length;
    }
    //插入
    public void insertNode(int index,Node node) throws Exception {
        //
        if(index<1||index>length()+1){
            throw  new Exception("插入位置不合法");
        }
        int length=1;
        Node tmp=header;
        int tmpLength = length();
        while(header.next!=null){//遍历单链表
            if(index==length++){//判断是否到达指定位置。
                node.next=tmp.next;//找到后将 当前的next 给要添加的node
                tmp.next=node;
                if(index==tmpLength+1){  //如果是链表尾部插入  需要重置 tail
                    tail=node;
                }
                return ;
            }
            tmp=tmp.next;
        }
    }
    //删除节点
    public Node deleteNode(int index) throws Exception {
        //
        if(index<1||index>length()+1){
            throw  new Exception("插入位置不合法");
        }
        int length=1;
        int tmpLength=length();
        Node<E> node = this.header; // node 是要删除节点的上一个节点
        while(node.next!=null){
            if(index==length++){
                Node tmp = node.next;
                node.next=node.next.next;
                if(index==tmpLength){
                    tail=node;
                }
                return tmp;
            }
            node=node.next;
        }
        return null;
    }


}
