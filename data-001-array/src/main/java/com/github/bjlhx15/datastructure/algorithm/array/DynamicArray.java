package com.github.bjlhx15.datastructure.algorithm.array;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/21 下午2:27
 */
public class DynamicArray <E>{
    /**
     * 存放数据的数组
     */
    private E[] data;
    /**
     * 数组中现有数据量
     */
    private int size;

    public DynamicArray(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }
    /**
     * 默认数组长度10
     */
    public DynamicArray() {
        new DynamicArray<>(10);
    }
    /**
     * 得到数组长度
     */
    public int getCapacity() {
        return data.length;
    }
    /**
     * 已有数组大小
     */
    public int getSize() {
        return size;
    }
    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 索引index处添加一个元素
     * 1.判断索引是否有效
     * 2.判断数组是否已经满了，若满了那么扩容
     * 3.从后往前，index处的元素后移一个位置
     * 4.index索引处元素赋值
     * 5.size++
     */
    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, index must between 0 and size");
        }
        if(index == size) {
            resize( 2 * data.length);
        }
        for (int i = size -1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
    /**
     * 在尾部添加新元素
     */
    public void addLast(E e) {
        add(size, e);
    }
    /**
     * 在头部添加新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 是否包含否个元素
     */
    public boolean contains(E e) {
        for (E e1 : data) {
            if(e1.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 动态扩容
     * 1.新建一个容器，大小为指定大小newCapacity
     * 2.将之前的容器的元素按原有顺序放到新的容器中
     * 3.将原指针指向新容器
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data,0,newData,0,data.length);
//        for(int i = 0; i < size; i++) {
//            newData[i] = data[i];
//        }
        data = newData;
    }
    /**
     * 查找元素E在数组中的索引
     * 1.遍历所有的数组，若匹配到(equals非==)那么返回索引，否则返回-1
     */
    private int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除元素并返回删除之前的位置
     * 若不存在则返回-1
     */
    public int removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
        return index;
    }
    /**
     * 根据索引删除元素,并返回删除元素
     * 1.判断索引是否有效
     * 2.将索引处的元素保存到单独一个变量，用于返回
     * 3.将所有元素左移，索引从小到大
     * 4.将size索引处的元素清空，并且size-1
     * 5.均摊算法复杂度。为防止算法复杂度振荡，只有size <= data.leng/4 那么重新调整数组大小为原大小二分之一
     *   注意数组容器大小不能为0
     */
    private E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index must between 0 and size -1");
        }
        E removeData = data[index];
        for(int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        data[index] = null;
        size--;
        if(size <= data.length/4 && data.length /2 != 0) {
            resize(data.length /2);
        }
        return removeData;
    }
}
