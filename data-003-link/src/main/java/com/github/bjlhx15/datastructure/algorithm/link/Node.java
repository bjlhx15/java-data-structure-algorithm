package com.github.bjlhx15.datastructure.algorithm.link;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/22 上午10:59
 */
public class Node <E>{
    E data;
    Node next;//指向该链结点的下一个链结点

    public Node(E data, Node next) {
        this.data = data;
        this.next = next;
    }
}
