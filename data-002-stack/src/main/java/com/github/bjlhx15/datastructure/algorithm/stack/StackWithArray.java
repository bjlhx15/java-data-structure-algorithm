package com.github.bjlhx15.datastructure.algorithm.stack;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/21 下午2:56
 */
public class StackWithArray<E> {
    private int size;       //栈大小
    private int top;        // 栈顶元素下标
    private E [] stackArray;      //栈容器

    public StackWithArray(int size) {
        stackArray = (E[])new Object[size];
        top=-1;
        this.size = size;
    }

    //入栈
    public void push(E e){
        stackArray[++top]=e;
    }
    //出栈
    public E pop(){
        return stackArray[top--];
    }

    //查看栈顶元素
    public E peek(){
        return stackArray[top];
    }
    //判空
    public boolean isEmpty(){
        return top==-1;
    }
    //判满
    public boolean isFull(){
        return top==size-1;
    }
}
