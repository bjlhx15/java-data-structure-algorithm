package com.github.bjlhx15.datastructure.algorithm.tree.suffixtree;

import org.junit.Test;

import static org.junit.Assert.*;

public class UkkonenSuffixTreeTest {

    @Test
    public void printTree() {
    }

    public static void main(String[] args) throws Exception {
        //test suffix-tree
        System.out.println("****************************");
        String text = "xbxb^"; //the last char must be unique!
        UkkonenSuffixTree stree = new UkkonenSuffixTree();
        stree.buildSuffixTree(text);
        stree.printTree();

        System.out.println("****************************");
        text = "mississippi^";
        stree = new UkkonenSuffixTree();
        stree.buildSuffixTree(text);
        stree.printTree();

        System.out.println("****************************");
        text = "GGGGGGGGGGGGCGCAAAAGCGAGCAGAGAGAAAAAAAAAAAAAAAAAAAAAA^";
        stree = new UkkonenSuffixTree();
        stree.buildSuffixTree(text);
        stree.printTree();

        System.out.println("****************************");
        text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ^";
        stree = new UkkonenSuffixTree();
        stree.buildSuffixTree(text);
        stree.printTree();

        System.out.println("****************************");
        text = "AAAAAAAAAAAAAAAAAAAAAAAAAA^";
        stree = new UkkonenSuffixTree();
        stree.buildSuffixTree(text);
        stree.printTree();

        System.out.println("****************************");
        text = "minimize";  //the last char e is different from other chars, so it is ok.
        stree = new UkkonenSuffixTree();
        stree.buildSuffixTree(text);
        stree.printTree();


        System.out.println("****************************");
        //the example from McCreight's: A Space-Economical Suffix Tree Construction Algorithm
        text = "bbbbbababbbaabbbbbc^";
        stree = new UkkonenSuffixTree();
        stree.buildSuffixTree(text);
        stree.printTree();


    }
}