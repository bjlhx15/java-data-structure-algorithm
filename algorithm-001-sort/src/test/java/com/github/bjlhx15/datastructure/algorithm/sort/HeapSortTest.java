package com.github.bjlhx15.datastructure.algorithm.sort;

import org.junit.Test;

import static com.github.bjlhx15.datastructure.algorithm.sort.HeapSort.heapSort;
import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void heapSortTest() {
        int i;
//        int[] a = {20,40,30,10,60,50};
        int[] a = {60,50,40,30,20,10};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        heapSort(a);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}