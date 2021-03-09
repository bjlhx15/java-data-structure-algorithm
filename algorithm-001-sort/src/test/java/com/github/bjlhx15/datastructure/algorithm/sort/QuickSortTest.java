package com.github.bjlhx15.datastructure.algorithm.sort;

import org.junit.Test;

import static com.github.bjlhx15.datastructure.algorithm.sort.QuickSort.quickSort;
import static com.github.bjlhx15.datastructure.algorithm.sort.QuickSort.quickSort2;
import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void quickSortTest() {
        int i;
        int a[] = {30,40,60,10,20,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        quickSort(a, 0, a.length-1);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
    @Test
    public void quickSort2Test() {
        int i;
        int a[] = {30,40,60,10,20,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        quickSort2(a, 0, a.length-1);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

}