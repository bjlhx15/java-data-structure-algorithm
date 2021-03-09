package com.github.bjlhx15.datastructure.algorithm.sort;

import org.junit.Test;

import static com.github.bjlhx15.datastructure.algorithm.sort.SelectSort.selectSort;
import static com.github.bjlhx15.datastructure.algorithm.sort.ShellSort.shellSort;
import static org.junit.Assert.*;

public class ShellSortTest {

    @Test
    public void shellSortTest() {

        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        shellSort(a);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}