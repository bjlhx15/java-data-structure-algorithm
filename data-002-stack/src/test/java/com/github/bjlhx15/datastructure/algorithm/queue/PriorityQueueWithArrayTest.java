package com.github.bjlhx15.datastructure.algorithm.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/22 上午10:22
 */
public class PriorityQueueWithArrayTest {


    @Test
    public void insert() throws Exception {
        PriorityQueueWithArray array=new PriorityQueueWithArray(5,2);
        array.insert(3);
        array.display();
        array.insert(1);
        array.display();
        array.insert(4);
        array.display();
        array.insert(2);
        array.display();
        array.insert(5);
        array.display();
    }
}