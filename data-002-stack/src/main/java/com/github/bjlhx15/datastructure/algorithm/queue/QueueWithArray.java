package com.github.bjlhx15.datastructure.algorithm.queue;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/22 上午9:44
 */
public class QueueWithArray<E> {
    private E[] queueArray;
    private int maxSize;
    private int front;
    private int rear;
    private int length;

    public QueueWithArray(int maxSize) {
        this.maxSize = maxSize;
        queueArray = (E[]) new Object[maxSize];
        front=0;
        rear=-1;
        length=0;
    }

    public void insert(E element) throws Exception {
        if(isFull()){
            throw  new Exception("队列已满");
        }
        //如果队尾指针已到达数组的末端，插入到数组的第一个位置
        if(rear==maxSize-1){
            rear=-1;
        }
        queueArray[++rear]=element;
        length++;
    }

    public E remove() throws Exception {
        if(isEmpty()){
            throw  new Exception("队列为空");
        }
        E e = queueArray[front++];
        //如果队头指针已到达数组末端，则移到数组第一个位置
        if(front==maxSize){
            front=0;
        }
        length--;
        return e;
    }

    public E peek() throws Exception {

        if(isEmpty()){
            throw  new Exception("队列为空");
        }
        return queueArray[front];
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public boolean isFull(){
        return length==maxSize;
    }
}
