package com.github.bjlhx15.datastructure.algorithm.sort;

/**
 * 快速排序
 */
public class QuickSort {


    public static void quickSort2(int a[], int low, int high) {
        if (low < high) {
            int i = low, j = high, key = a[i];
            while (i < j) {
                //先看右边，依次往左递减 找到比基准值 key 小的 退出循环，准备和下面的大于的换
                while (i < j && key <= a[j]) {
                    j--;
                }
                //在看做边，依次往右递增 找到比基准值key 大的的 退出循环，准备和上面面的小于的换
                while (i < j && a[i] <= key) {
                    i++;
                }
                //如果i<j，交换它们
                if (i < j) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
            //最后将基准为与i和j相等位置的数字交换
            a[low] = a[i];
            a[i] = key;//把基准值放到合适的位置
            //递归调用左半数组
            quickSort2(a, low, j - 1);
            //递归调用右半数组
            quickSort2(a, j + 1, high);
        }
    }



    /*
     * 快速排序
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
     *     r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int i, j, key;
            i = low;
            j = high;
            key = a[i];//基准位置
            //基准数据归位
            while (i < j) {
                while (i < j && a[j] > key)
                    j--; // 从右向左找第一个小于x的数
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < key)
                    i++; // 从左向右找第一个大于x的数
                if (i < j)
                    a[j--] = a[i];
            }
            a[i] = key;

            quickSort(a, low, i - 1); /* 递归调用 左半数组 */
            quickSort(a, i + 1, high); /* 递归调用 右半数组 */
        }
    }
}
