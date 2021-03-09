package com.github.bjlhx15.datastructure.algorithm.sort;

import org.junit.Test;

import static com.github.bjlhx15.datastructure.algorithm.sort.InsertSort.insertSort;
import static org.junit.Assert.*;

public class InsertSortTest {

    @Test
    public void insertSortTest() {

        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        insertSort(a);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}