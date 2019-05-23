package com.github.bjlhx15.datastructure.algorithm.tree.hashtree;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayHashTreeTest {
    @Test
    public void test() {
        ArrayHashTree tree = new ArrayHashTree();
        System.out.println(tree.root);
        tree.insertNode(2);
        tree.insertNode(3);
        tree.insertNode(4);
        tree.insertNode(5);
        tree.insertNode(6);
        tree.insertNode(7);
        tree.insertNode(8);
        tree.insertNode(9);
        tree.insertNode(10);
        System.out.println(tree.root);
        System.out.println(tree.searchNode(3));
        tree.displayTree();
        tree.deleteNode(3);
        System.out.println(tree.root);
        System.out.println(tree.searchNode(3));
        System.out.println(tree.searchNode(2));
        System.out.println(tree.searchNode(4));
    }

}