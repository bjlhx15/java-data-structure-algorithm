package com.github.bjlhx15.datastructure.algorithm.tree.hashtree;

import java.util.LinkedList;

public class LinkHashTree  <Key,Value>{ //泛型
    private int Num;
    private int capacity;
    private LinkedList<Key,Value>[] ht;
    class LinkedList<Key,Value> {
        private Node first;

        private class Node {
            Key key;
            Value val;
            Node next;

            public Node(Key key, Value val, Node next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }

        public Value get(Key key) {
            for (Node x = first; x != null;x = x.next) {
                if (key.equals(x.key)) return x.val;
            }
            return null;
        }

        public void put(Key key, Value val) {
            for (Node x = first; x != null;x = x.next) {
                if (key.equals(x.key)) {
                    x.val = val;
                    return;
                }
            }
            first = new Node(key,val,first); // 从头部加入新节点
        }


    }

    public LinkHashTree() {
        this(1);
    }

    public LinkHashTree(int capacity) {
        ht = (LinkedList<Key,Value>[]) new LinkedList[capacity];
        this.capacity = capacity;
        for (int i =0;i < capacity;i++)
            ht[i] = new LinkedList<Key,Value>();
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public Value get(Key key) {
        return ht[ hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        Num++;
        ht[hash(key)].put(key,value);
    }

}