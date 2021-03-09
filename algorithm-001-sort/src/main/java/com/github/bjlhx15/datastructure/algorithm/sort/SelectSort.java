package com.github.bjlhx15.datastructure.algorithm.sort;

public class SelectSort {
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;//无序区中最小元素位置

            // 找出"a[i+1] ... a[n]"之间的最小元素，并赋值给min。
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }

            // 若min!=i，则交换 a[i] 和 a[min]。
            // 交换之后，保证了a[0] ... a[i] 之间的元素是有序的。
            if (min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }
}
