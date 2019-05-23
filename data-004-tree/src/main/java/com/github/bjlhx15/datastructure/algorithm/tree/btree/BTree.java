package com.github.bjlhx15.datastructure.algorithm.tree.btree;


import java.util.ArrayList;
import java.util.List;

public class BTree<K extends Comparable<K>> {

    private final int degree;
    private AbstractBTreeNode<K> root;

    public BTree(int degree){
        if (degree < 2){
            throw new IllegalArgumentException("degree mustn't < 2");
        }
        this.degree = degree;
        root = new BTreeLeaf<>(degree);
    }

    public AbstractBTreeNode<K> getRoot(){
        return root;
    }
    /**
     * Insert a key into B-Tree.
     *
     * @param key key to insert.
     */
    public void insert(K key){
        AbstractBTreeNode<K> n = root;
        if (root.isFull()){
            AbstractBTreeNode<K> newRoot = new BTreeInternalNode<>(degree);
            newRoot.insertChild(n,0);
            newRoot.splitChild(0);
            n = newRoot;
            root = newRoot;
        }
        n.insertNotFull(key);
    }

    /**
     * Delete a key from B-Tree,if key doesn't exist in current tree,will effect nothing.
     *
     * @param key key to delete.
     */
    public void delete(K key){
        AbstractBTreeNode<K> node = root;
        node.deleteNotEmpty(key);
        if (node.nkey() == 0){
            //shrink
            root = node.getChild(0);
            if (root == null){
                root = new BTreeLeaf<>(degree);
            }
        }
    }

    @Override
    public String toString() {
        return AbstractBTreeNode.BTreeToString(this.root);
    }

    //以树的形式打印出该树
    public void displayTree() {
        int depth = getTreeDepth();
        ArrayList<AbstractBTreeNode> currentLayerNodes = new ArrayList<AbstractBTreeNode>();
        currentLayerNodes.add(root);  //存储该层所有节点
        int layerIndex = 1;
        while (layerIndex <= depth) {
            int NodeBlankNum = (int) Math.pow(2, depth - layerIndex) - 1;  //在节点之前和之后应该打印几个空位
            for (int i = 0; i < currentLayerNodes.size(); i++) {
                AbstractBTreeNode node = currentLayerNodes.get(i);
                printBlank(NodeBlankNum);   //打印节点之前的空位

                if (node == null) {
                    System.out.print("*\t");  //如果该节点为null，用空位代替
                } else {
                    int tmp=0;
                    for (int j = 0; j < node.nkey(); j++) {
                        System.out.print(node.getKey(j));  //打印该节点
                        if(++tmp!=node.nkey()){
                            System.out.print( ",");  //打印该节点
                        }
                    }
                    System.out.print("\t");  //如果该节点为null，用空位代替
                }

                printBlank(NodeBlankNum);  //打印节点之后的空位
//                System.out.print("*\t");   //补齐空位
            }
            System.out.println();
            layerIndex++;
            currentLayerNodes = getAllNodeOfThisLayer(currentLayerNodes);  //获取下一层所有的节点
        }
    }

    //获取树的深度
    public int getTreeDepth() {
        if (root == null) {
            return 0;
        }
        return degree+1;// getDepth(root, 1);
    }

    //私有方法，用迭代方法来获取左子树和右子树的最大深度，返回两者最大值
//    private int getDepth(AbstractBTreeNode currentNode, int initDeep) {
//        int deep = initDeep;  //当前节点已到达的深度
//        int leftDeep = initDeep;
//        int rightDeep = initDeep;
//        if (currentNode.() != null) {  //计算当前节点左子树的最大深度
//            leftDeep = getDepth(currentNode.left, deep + 1);
//        }
//        if (currentNode.right != null) {  //计算当前节点右子树的最大深度
//            rightDeep = getDepth(currentNode.right, deep + 1);
//        }
//
//        return Math.max(leftDeep, rightDeep);
//    }

    //打印指定个数的空位
    private void printBlank(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("*\t");
        }
    }

    //获取指定节点集合的所有子节点
    private ArrayList getAllNodeOfThisLayer(List parentNodes) {
        ArrayList list = new ArrayList<AbstractBTreeNode>();
        AbstractBTreeNode parentNode;
        for (int i = 0; i < parentNodes.size(); i++) {
            parentNode = (AbstractBTreeNode) parentNodes.get(i);
            for (int j = 0; j < parentNode.nchild(); j++) {
                AbstractBTreeNode child = parentNode.getChild(j);

                list.add(child);
            }
            {  //如果上层父节点不存在，用两个null占位，代表左右子节点
//                list.add(null);
//                list.add(null);
            }
        }
        return list;
    }
}
