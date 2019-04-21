package com.github.bjlhx15.datastructure.algorithm.array;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * 无序数组
 * @since 2019/4/15 下午1:40
 */
public class NoOrderArray<T> {
    private T[] strArray;
    private int length = 0;       //数组元素个数

    //构造方法，传入数组最大长度
    public NoOrderArray(int max) {
        strArray = (T[])new Object[max];   // 创建泛型数组
    }

    //检测数组是否包含某个元素，如果存在返回其下标，不存在则返回-1
    public int contains(T target) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (strArray[i].equals(target)) {
                index = i;
                break;
            }
        }
        return index;
    }

    //插入
    public void insert(T elem) {
        strArray[length] = elem;
        length++;
    }

    //删除某个指定的元素值，删除成功则返回true，否则返回false
    public boolean delete(T target) {
        int index = -1;
        if ((index = contains(target)) != -1) {
            for (int i = index; i < length - 1; i++) {
                //删除元素之后的所有元素前移一位
                strArray[i] = strArray[i + 1];
            }
            length--;
            return true;
        } else {
            return false;
        }
    }

    //列出所有元素
    public void display() {
        for (int i = 0; i < length; i++) {
            System.out.print(strArray[i] + "\t");
        }
    }

}
