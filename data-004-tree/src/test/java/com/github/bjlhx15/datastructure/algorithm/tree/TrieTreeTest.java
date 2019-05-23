package com.github.bjlhx15.datastructure.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTreeTest {

    @Test
    public void insert() {
    }

    public static void main(String[]args)
    {
        TrieTree tree=new TrieTree();
        String[] strs= {"banana","band","bee","absolute","acm",};
        String[] prefix= {"ba","b","band","abc",};
        //构建字典
        for(String str:strs)
        {
            tree.insert(str);
        }
        System.out.println(tree.has("abc"));
        tree.preTraverse(tree.getRoot());
        System.out.println();
        //tree.printAllWords();
        for(String pre:prefix)
        {
            int num=tree.countPrefix(pre);
            System.out.println(pre+"数量:"+num);
        }

//        tree.displayTree();
    }
}