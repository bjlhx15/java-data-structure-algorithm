package com.github.bjlhx15.datastructure.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree binaryTree = null;

    @Before
    public void setUp() throws Exception {
        binaryTree = new BinaryTree();

//        int[] array = {8, 5, 14, 3, 7, 12, 18, 4, 6, 10, 13, 16, 20};
        int[] array ={15,5,16,3,12,20,10,13,18,23,6,7};
        for (int i = 0; i < array.length; i++) {
            Node nodeTmp = new Node();
            nodeTmp.data = array[i];
            binaryTree.insert(nodeTmp);
        }
    }

    @Test
    public void find() {
        Node node = binaryTree.find(8);
        System.out.println(node.data);
    }

    @Test
    public void insert() {
        Node nodeTmp = new Node();
        nodeTmp.data = 11;
        binaryTree.insert(nodeTmp);
        display();
    }

    @Test
    public void display() {
        binaryTree.displayTree();

    }

    @Test
    public void delete() {
        Node nodeTmp = new Node();
        nodeTmp.data = 16;
        binaryTree.delete(nodeTmp);
        display();

    }

    @Test
    public void preorder() {
        binaryTree.traverse(1);
    }

    @Test
    public void inorder() {
        binaryTree.traverse(2);
    }

    @Test
    public void postorder() {
        binaryTree.traverse(3);
    }
}