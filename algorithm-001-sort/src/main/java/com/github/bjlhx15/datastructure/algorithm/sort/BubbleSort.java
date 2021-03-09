package com.github.bjlhx15.datastructure.algorithm.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    /*
     * 冒泡排序 下沉排序
     */
    public static void bubbleSort1(int[] a) {
        int i,j,n=a.length;
        if (n <= 1) return;       //如果只有一个元素就不用排序了

        //倒着来，主要是大数下沉
        //循环数组长度次
        for (i=n-1; i>0; i--) {
            // 将a[0...i]中最大的数据放在末尾
            // j<i 含义是，每一次比较后，都会有一个相对大数排在最后
            for (j=0; j<i; j++) {
                if (a[j] > a[j+1]) {//相邻的两个数比较，前面的大于后面的交换即可
                    // 交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    /*
     * 冒泡排序(改进版) 下沉排序
     */
    public static void bubbleSort2(int[] a) {
        int i,j,n=a.length;
        if (n <= 1) return;       //如果只有一个元素就不用排序了

        for (i=n-1; i>0; i--) {

            boolean flag = false; // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            // 将a[0...i]中最大的数据放在末尾
            for (j=0; j<i; j++) {
                if (a[j] > a[j+1]) {
                    // 交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;

                    flag = true;    // 若发生交换，则设标记为1
                }
            }

            if (!flag)
                break;            // 若没发生交换，则说明数列已有序。
        }
    }


    public static void bubbleSort4(int a[]){

        for (int i = a.length-1; i >0; i--) {
            boolean flag =false;
            for (int j = 0; j < i; j++) {
                if(a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1]= tmp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

}
