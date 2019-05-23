package com.github.bjlhx15.datastructure.algorithm.tree.hashtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayHashTree {
    public static final int[] primeNumber = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};//连续11个质数能表示6464693230个数字

    class Node {
        //node的下一层的节点
        public Node[] next;
        //节点的值
        public int value;
        //节点是否已被删除
        public boolean isDel;

        public Node(int value, int nextNum) {
            this.value = value;
            this.next = new Node[nextNum];
            this.isDel = false;
        }

        @Override
        public String toString() {
            return "Node [next=" + Arrays.toString(next) + ", value=" + value + ", isDel=" + isDel + "]";
        }
    }


    Node root;

    /**
     * HashTree初始化
     * 对根节点的值设置成0，但是被删除的节点
     */
    public ArrayHashTree() {
        root = new Node(0, primeNumber[0]);
        root.isDel = true;
    }


    /**
     * 在HashTree中插入一个节点
     *
     * @param value 节点的值
     */
    public void insertNode(int value) {
        //如果HashTree中已经有这个节点，就不插入
        if (searchNode(value)) {
            return;
        }
        //排除root节点被删除或者初始化的情况
        if (root.isDel == true) {
            root.value = value;
            root.isDel = false;
            return;
        }
        //层级，在每一层，primeNumber[level]为下一层的节点数
        int level = 0;
        Node nowNode = root;
        while (true) {
            //得到下个节点的位置（因为已经考虑了root，可以直接考虑下一层的情况）
            int index = value % (primeNumber[level]);
            if (nowNode.next[index] == null) {
                //在第n层，primeNumber[level]为n+1层的节点数，primeNumber[level+1]为n+2层的节点数
                //在第n层nowNode.next[index]为第n+1层的节点，它的next的数量为n+2层的节点数
                nowNode.next[index] = new Node(value, primeNumber[level + 1]);
                break;
            }
            //将被删除的节点更新为当前值
            if (nowNode.next[index].isDel == true) {
                nowNode.next[index].value = value;
                nowNode.next[index].isDel = false;
                break;
            }
            //到下一个对应节点
            nowNode = nowNode.next[index];
            level++;
        }
    }

    /**
     * 在HashTree中查询节点是否存在
     *
     * @param value 节点的值
     * @return 存在，返回true  不存在，返回false
     */
    public boolean searchNode(int value) {
        //考虑root是查找节点
        if (root.value == value && root.isDel == false) {
            return true;
        }
        //层级，在每一层，primeNumber[level]为下一层的节点数
        int level = 0;
        Node nowNode = root;
        while (true) {
            //得到下个节点的位置（因为已经考虑了root，可以直接考虑下一层的情况）
            int index = value % (primeNumber[level]);
            //如果对应节点为空，直接返回false
            if (nowNode.next[index] == null) {
                return false;
            }
            //如果对应节点没有被删除而且值相同，直接返回false
            if (nowNode.next[index].isDel == false && nowNode.next[index].value == value) {
                return true;
            }
            //到下一个对应节点
            nowNode = nowNode.next[index];
            level++;
        }
    }


    /**
     * 在HashTree中删除值为value的节点
     *
     * @param value 节点的值
     * @return 如果删除成功，返回true   如果HashTree中没有这个节点或者已经被删除，返回false
     */
    public boolean deleteNode(int value) {
        //考虑root是被删除节点
        if (root.value == value && root.isDel == false) {
            root.isDel = true;
            return true;
        }
        //层级，在每一层，primeNumber[level]为下一层的节点数
        int level = 0;
        Node nowNode = root;
        while (true) {
            //得到下个节点的位置（因为已经考虑了root，可以直接考虑下一层的情况）
            int index = value % (primeNumber[level]);
            //如果对应节点为空，直接返回false
            if (nowNode.next[index] == null) {
                return false;
            }
            //如果对应节点没有被删除而且值相同，进行删除，返回true
            if (nowNode.next[index].isDel == false && nowNode.next[index].value == value) {
                nowNode.next[index].isDel = true;
                return true;
            }
            //到下一个对应节点
            nowNode = nowNode.next[index];
            level++;
        }
    }

    //以树的形式打印出该树
    public void displayTree() {
        int depth = getTreeDepth2();
        ArrayList<Node> currentLayerNodes = new ArrayList<Node>();
        currentLayerNodes.add(root);  //存储该层所有节点
        int layerIndex = 1;
        while (layerIndex <= depth) {
            int NodeBlankNum = (int) Math.pow(2, depth - layerIndex) - 1;  //在节点之前和之后应该打印几个空位
//            int NodeBlankNum=getArrayN(depth-layerIndex);
            for (int i = 0; i < currentLayerNodes.size(); i++) {
                Node node = currentLayerNodes.get(i);
                printBlank(NodeBlankNum);   //打印节点之前的空位

                if (node == null) {
                    System.out.print("*\t");  //如果该节点为null，用空位代替
                } else {
                    System.out.print(node.value + "\t");  //打印该节点
                }

                printBlank(NodeBlankNum);  //打印节点之后的空位
                System.out.print("*\t");   //补齐空位
            }
            System.out.println();
            layerIndex++;
            currentLayerNodes = getAllNodeOfThisLayer(currentLayerNodes);  //获取下一层所有的节点
        }
    }

    public int getArrayN(int num) {
        int tmp=1;
        for(int i=0;i<num;i++){
            tmp=primeNumber[i]*tmp;
        }
        return tmp;
    }


    //获取树的深度
    public int getTreeDepth2() {
        if (root == null) {
            return 0;
        }
        int count = count(root, 1);
        return getDepthByCount(count, 1, 0);
    }


    //  9 1 0
    // →9 2 1
    // →9 6 2
    // →9 30 3

    public int getDepthByCount(int count, int base, int i) {
        int i1 = primeNumber[i] * base;
        ++i;
        if (count <= i1) {
            return i;
        } else {
            return getDepthByCount(count, i1, i);
        }
    }

    int tmpCount = 1;

    public int count(Node currentNode, int initCount) {
        if (currentNode != null && currentNode.next != null) {
            for (int i = 0; i < currentNode.next.length; i++) {
                if (currentNode.next[i] != null) {
                    tmpCount++;
                    count(currentNode.next[i], tmpCount);
                }
            }
        }
        return tmpCount;
    }

    //打印指定个数的空位
    private void printBlank(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("*\t");
        }
    }

    //获取指定节点集合的所有子节点
    private ArrayList getAllNodeOfThisLayer(List parentNodes) {
        ArrayList list = new ArrayList<Node>();
        Node parentNode;
        for (int i = 0; i < parentNodes.size(); i++) {
            parentNode = (Node) parentNodes.get(i);
            if (parentNode != null) {
                for (int j = 0; j < parentNode.next.length; j++) {
                    if (parentNode.next[j] != null) {
                        list.add(parentNode.next[j]);
                    }
                }
//                if (parentNode.left != null) {  //如果上层的父节点存在左子节点，加入集合
//                    list.add(parentNode.left);
//                } else {
//                    list.add(null);  //如果上层的父节点不存在左子节点，用null代替，一样加入集合
//                }
//                if (parentNode.right != null) {
//                    list.add(parentNode.right);
//                } else {
//                    list.add(null);
//                }
            } else {  //如果上层父节点不存在，用两个null占位，代表左右子节点
                list.add(null);
                list.add(null);
            }
        }
        return list;
    }
}