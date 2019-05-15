package com.github.bjlhx15.datastructure.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public Node find(int key) {
        Node cur = root;
        if (null == cur) {
            return null;
        }
        while (cur.data != key) {
            cur = key < cur.data ? cur.leftChild : cur.rightChild;
            if (null == cur) {
                return null;
            }
        }
        return cur;
    }

    public void insert(Node node) {
        if (null == root) {
            root = node;
        } else {
            Node cur = root;
            while (true) {
                if (node.data < cur.data) {
                    if (null == cur.leftChild) {
                        cur.leftChild = node;
                        return;
                    }
                    cur = cur.leftChild;
                } else {
                    if (null == cur.rightChild) {
                        cur.rightChild = node;
                        return;
                    }
                    cur = cur.rightChild;
                }
            }
        }
    }


    public boolean delete(Node node) {
        if (null == node) {
            return false;
        }
        boolean isLeftChild = true; //目标是否为父节点的左子节点
        Node cur = root; //待删除 节点
        Node parent = null; //待删除节点的父节点

        while (cur.data != node.data) { //找到要删除的节点，以及父节点
            parent = cur;
            if (node.data < cur.data) {
                cur = cur.leftChild;
                isLeftChild = true;
            } else {
                isLeftChild = false;
                cur = cur.rightChild;
            }

            if (null == cur) {//没找到
                return false;
            }
        }

        if (null == cur.leftChild && null == cur.rightChild) {//没有子节点了
            if (cur == root) {//要删除的是根节点
                root = null;
            } else if (isLeftChild) { //要删除的不是根节点，则该节点肯定有父节点，并且是左子节点，该节点删除后，需要将父节点指向它的引用置空
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (null == cur.leftChild) { //只有一个右子节点
            if (cur == root) {//要删除的是根节点
                root = cur.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = cur.rightChild;
            } else {
                parent.rightChild = cur.rightChild;
            }
        } else if (null == cur.rightChild) { //只有一个左子节点
            if (cur == root) {//要删除的是根节点
                root = cur.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = cur.leftChild;
            } else {
                parent.rightChild = cur.leftChild;
            }
        } else {//有两个
            //1、找到当前节点的后继节点
            Node successor = cur.rightChild;
            Node successorParent = null;
            while (successor.leftChild != null) {
                successorParent = successor;
                successor = successor.leftChild;
            }
            //欲删除节点的右子节点就是它的后继，证明该后继无左子节点，则将以后继节点为根的子树上移即可
            if (null == successorParent) {
                if (cur == root) {//要删除的为根节点，则将后继设置为根，且根的左子节点设置为欲删除节点的做左子节点
                    root = successor;
                    root.leftChild = cur.leftChild;

                } else if (isLeftChild) {
                    parent.leftChild = successor;
                    successor.leftChild = cur.leftChild;
                } else {
                    parent.rightChild = successor;
                    successor.leftChild = cur.leftChild;
                }
            } else { //欲删除节点的后继不是它的右子节点
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = cur.rightChild;
                if (cur == root) {
                    root = successor;
                    root.leftChild = cur.leftChild;
                } else if (isLeftChild) {
                    parent.leftChild = successor;
                    successor.leftChild = cur.leftChild;
                } else {
                    parent.rightChild = successor;
                    successor.leftChild = cur.leftChild;
                }
            }
        }
        return true;

    }

    public static final int PREORDER = 1;   //前序遍历
    public static final int INORDER = 2;    //中序遍历
    public static final int POSTORDER = 3;  //中序遍历

    //遍历
    public void traverse(int type){
        switch(type){
            case 1:
                System.out.print("前序遍历：\t");
                preorder(root);
                System.out.println();
                break;
            case 2:
                System.out.print("中序遍历：\t");
                inorder(root);
                System.out.println();
                break;
            case 3:
                System.out.print("后序遍历：\t");
                postorder(root);
                System.out.println();
                break;
        }
    }

    //前序遍历
    public void preorder(Node currentRoot){
        if(currentRoot != null){
            System.out.print(currentRoot.data+"\t");
            preorder(currentRoot.leftChild);
            preorder(currentRoot.rightChild);
        }
    }

    //中序遍历，这三种遍历都用了迭代的思想
    public void inorder(Node currentRoot){
        if(currentRoot != null){
            inorder(currentRoot.leftChild);  //先对当前节点的左子树对进行中序遍历
            System.out.print(currentRoot.data+"\t"); //然后访问当前节点
            inorder(currentRoot.rightChild);  //最后对当前节点的右子树对进行中序遍历
        }
    }

    //后序遍历
    public void postorder(Node currentRoot){
        if(currentRoot != null){
            postorder(currentRoot.leftChild);
            postorder(currentRoot.rightChild);
            System.out.print(currentRoot.data+"\t");
        }
    }

    //私有方法，用迭代方法来获取左子树和右子树的最大深度，返回两者最大值
    private int getDepth(Node currentNode,int initDeep){
        int deep = initDeep;  //当前节点已到达的深度
        int leftDeep = initDeep;
        int rightDeep = initDeep;
        if(currentNode.leftChild != null){  //计算当前节点左子树的最大深度
            leftDeep = getDepth(currentNode.leftChild, deep+1);
        }
        if(currentNode.rightChild != null){  //计算当前节点右子树的最大深度
            rightDeep = getDepth(currentNode.rightChild, deep+1);
        }

        return Math.max(leftDeep, rightDeep);
    }

    //获取树的深度
    public int getTreeDepth(){
        if(root == null){
            return 0;
        }
        return getDepth(root,1);
    }

    //返回关键值最大的节点
    public Node getMax(){
        if(isEmpty()){
            return null;
        }
        Node cur = root;
        while(cur.rightChild != null){
            cur = cur.rightChild;
        }
        return cur;
    }

    //返回关键值最小的节点
    public Node getMin(){
        if(isEmpty()){
            return null;
        }
        Node cur = root;
        while(cur.leftChild != null){
            cur = cur.leftChild;
        }
        return cur;
    }

    //以树的形式打印出该树
    public void displayTree(){
        int depth = getTreeDepth();
        ArrayList<Node> currentLayerNodes = new ArrayList<Node> ();
        currentLayerNodes.add(root);  //存储该层所有节点
        int layerIndex = 1;
        while(layerIndex <= depth){
            int NodeBlankNum = (int)Math.pow(2, depth-layerIndex)-1;  //在节点之前和之后应该打印几个空位
            for(int i = 0;i<currentLayerNodes.size();i++){
                Node node = currentLayerNodes.get(i);
                printBlank(NodeBlankNum);   //打印节点之前的空位

                if(node == null){
                    System.out.print("*\t");  //如果该节点为null，用空位代替
                }else{
                    System.out.print(node.data+"\t");  //打印该节点
                }

                printBlank(NodeBlankNum);  //打印节点之后的空位
                System.out.print("*\t");   //补齐空位
            }
            System.out.println();
            layerIndex++;
            currentLayerNodes = getAllNodeOfThisLayer(currentLayerNodes);  //获取下一层所有的节点
        }
    }

    //获取指定节点集合的所有子节点
    private ArrayList getAllNodeOfThisLayer(List                                                    parentNodes){
        ArrayList list = new ArrayList<Node>();
        Node parentNode;
        for(int i=0;i<parentNodes.size();i++){
            parentNode = (Node)parentNodes.get(i);
            if(parentNode != null){
                if(parentNode.leftChild != null){  //如果上层的父节点存在左子节点，加入集合
                    list.add(parentNode.leftChild);
                }else{
                    list.add(null);  //如果上层的父节点不存在左子节点，用null代替，一样加入集合
                }
                if(parentNode.rightChild != null){
                    list.add(parentNode.rightChild);
                }else{
                    list.add(null);
                }
            }else{  //如果上层父节点不存在，用两个null占位，代表左右子节点
                list.add(null);
                list.add(null);
            }
        }
        return list;
    }

    //打印指定个数的空位
    private void printBlank(int num){
        for(int i=0;i<num;i++){
            System.out.print("*\t");
        }
    }

    //判空
    public boolean isEmpty(){
        return (root == null);
    }

    //判断是否为叶子节点
    public boolean isLeaf(Node node){
        return (node.leftChild != null || node.rightChild != null);
    }

    //获取根节点
    public Node getRoot(){
        return root;
    }


}
