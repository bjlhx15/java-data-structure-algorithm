package com.github.bjlhx15.datastructure.algorithm.link;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/22 下午6:14
 */
public class DoubleLinkTest {
    DoubleLink<Integer> doubleLink = null;

    @Before
    public void setUp() throws Exception {
        doubleLink = new DoubleLink<>();
        doubleLink.addNode(new Node(1));
        doubleLink.addNode(new Node(2));
        doubleLink.addNode(new Node(3));
    }

    @Test
    public void addNode() {
        doubleLink.addNode(new Node(4));
        System.out.println(111);

    }
    @Test
    public void deleteNode() throws Exception {
        doubleLink.deleteNode(2);
        System.out.println(111);

    }
    @Test
    public void deleteLastNode() throws Exception {
        doubleLink.deleteNode(3);
        System.out.println(111);

    }
}