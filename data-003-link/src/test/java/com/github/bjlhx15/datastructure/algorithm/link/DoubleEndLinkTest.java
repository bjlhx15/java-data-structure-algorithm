package com.github.bjlhx15.datastructure.algorithm.link;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/22 下午3:38
 */
public class DoubleEndLinkTest {
    DoubleEndLink<Integer> doubleEndLink = null;

    @Before
    public void setUp() throws Exception {
        doubleEndLink = new DoubleEndLink<>();
        doubleEndLink.addNode(new Node(1));
        doubleEndLink.addNode(new Node(2));
        doubleEndLink.addNode(new Node(3));
    }

    @Test
    public void addNode() throws Exception {
        System.out.println(doubleEndLink.length());
        doubleEndLink.insertNode(4, new Node(4));

        System.out.println(doubleEndLink);

    }

    @Test
    public void deleteNode() throws Exception {
        System.out.println(doubleEndLink.length());
        Node node = doubleEndLink.deleteNode(3);

        System.out.println(doubleEndLink);

    }

    @Test
    public void deleteLastNode() throws Exception {
        System.out.println(doubleEndLink.length());
        Node node = doubleEndLink.deleteNode(3);

        System.out.println(doubleEndLink);

    }
}