package com.github.bjlhx15.datastructure.algorithm.sort;

import org.junit.Test;

import static com.github.bjlhx15.datastructure.algorithm.sort.MergeSort.mergeSort;
import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void mergeSortTest() {

//        int[] nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 10 };
        int[] nums = new int[] { 9, 8, 62};
        int[] newNums = mergeSort(nums, 0, nums.length - 1);
        for (int x : newNums) {
            System.out.println(x);
        }
    }
}