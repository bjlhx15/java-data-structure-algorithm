package com.github.bjlhx15.datastructure.algorithm.link;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/22 上午10:53
 */
public class Link<E> {
    private Node<E> header;

    public Link() {
        header=new Node<>(null,null);
    }
    //最后位置添加
    public void addNode(Node node){
        //链表中有结点，遍历到最后一个结点
        Node tmp=header;
        while (tmp.next!=null){
            tmp=header.next;
        }
        tmp.next=node;
    }

    public int length(){
        int length=0;
        Node<E> node = this.header;
        while (node.next!=null){
            length++;
            node=node.next;
        }
        return length;
    }
    //插入
    public void insertNode(int index,Node node) throws Exception {
        //
        if(index<1||index>length()+1){
            throw  new Exception("插入位置不合法");
        }
        int length=1;
        Node tmp=header;

        while(header.next!=null){//遍历单链表
            if(index==length++){//判断是否到达指定位置。
                node.next=tmp.next;//找到后将 当前的next 给要添加的node
                tmp.next=node;
                return ;
            }
            tmp=tmp.next;
        }
    }
    //删除节点
    public Node deleteNode(int index) throws Exception {
        //
        if(index<1||index>length()+1){
            throw  new Exception("插入位置不合法");
        }
        int length=1;
        Node<E> node = this.header; // node 是要删除节点的上一个节点
        while(node.next!=null){
            if(index==length++){
                //
                node.next=node.next.next;
                return node.next;
            }
            node=node.next;
        }
        return null;
    }

    /**
     * 对链表中的结点进行排序，按照从小到大的顺序，使用选择排序。
     *         使用双层遍历。第一层遍历，正常遍历链表，第二层遍历，遍历第一层遍历时所用的结点后面所有结点并与之比较
     *         选择排序比较简单，明白其原理，就能够写的出来。
     */
    public void selectSortNode() throws Exception {
        //判断链表长度大于2，不然只有一个元素，就不用排序了。
        if(length()<2){
            System.out.println("无需排序");
            return;
        }
        if(!header.data.getClass().getName().equals(Integer.TYPE.getName())){
            throw  new  Exception("不支持非数据值类型排序");
        }
        //选择排序
        Node temp = header;            //第一层遍历使用的移动指针，最处指向头结点，第一个结点用temp.next表示
        while(temp.next != null){    //第一层遍历链表，从第一个结点开始遍历
            Node secondTemp = temp.next;        //第二层遍历使用的移动指针，secondTemp指向第一个结点，我们需要用到是第二个结点开始，所以用secondNode.next
            while(secondTemp.next != null){//第二层遍历,从第二个结点开始遍历
                if( (int)temp.next.data > (int)secondTemp.next.data){    //第二层中的所有结点依次与第一次遍历中选定的结点进行比较，
                    int t = (int)secondTemp.next.data;
                    secondTemp.next.data =  temp.next.data;
                    temp.next.data = t;
                }
                secondTemp = secondTemp.next;
            }
            temp = temp.next;
        }
    }

    /**
     * 对链表进行插入排序，按从大到小的顺序，只要这里会写，那么手写用数组插入排序
     *    也是一样的。先要明白原理。什么是插入排序，这样才好写代码。
     *    插入排序：分两组，一组当成有序序列，一组当成无序，将无序组中的元素与有序组中的元素进行比较(如何比较，那么就要知道插入排序的原理是什么这里不过多阐述)
     *        这里我想到的方法是，构建一个空的链表当成有序序列，而原先的旧链表为无序序列，按照原理，一步步进行编码即可。
     *
     */
    public void insertSortNode() throws Exception {
        //判断链表长度大于2，不然只有一个元素，就不用排序了。
        if(length()<2){
            System.out.println("无需排序");
            return;
        }
        if(!header.data.getClass().getName().equals(Integer.TYPE.getName())){
            throw  new  Exception("不支持非数据值类型排序");
        }
        //创建新链表
        Node newHead = new Node(0,null);    //新链表的头结点
        Node newTemp = newHead;        //新链表的移动指针
        Node temp = header;        //旧链表的移动指针
        if(newTemp.next == null){        //将第一个结点直接放入新链表中。
            Node node = new Node(temp.next.data,null);
            newTemp.next = node;
            temp = temp.next;    //旧链表中指针移到下一位(第二个结点处)。
        }
        while(temp.next != null){     //    遍历现有链表
            while(newTemp.next != null){
                //先跟新链表中的第一个结点进行比较,如果符合条件则添加到新链表，注意是在第一个位置上增加结点
                //如果不符合，则跟新链表中第二个结点进行比较，如果都不符合，跳出while，判断是否是到了新链表的最后一个结点，如果是则直接在新链表后面添加即可

                if((int)newTemp.next.data < (int)temp.next.data){
                    Node node = new Node(temp.next.data,null);
                    node.next = newTemp.next;
                    newTemp.next = node;
                    break;
                }
                newTemp = newTemp.next;
            }
            if(newTemp.next == null){//到达最末尾还没符合，那么说明该值是新链表中最小的数，直接添加即可到链表中即可
                //直接在新链表后面添加
                Node node = new Node(temp.next.data,null);
                newTemp.next = node;
            }
            //旧链表指针指向下一位结点，继续重复和新链表中的结点进行比较。
            temp = temp.next;
            //新链表中的移动指针需要复位，指向头结点
            newTemp = newHead;
        }
        //开始使用新链表，旧链表等待垃圾回收机制将其收回。
        header = newHead;

    }
}
