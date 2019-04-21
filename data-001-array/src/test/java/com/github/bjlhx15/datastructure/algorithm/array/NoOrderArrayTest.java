package com.github.bjlhx15.datastructure.algorithm.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/15 下午2:05
 */
public class NoOrderArrayTest {

    private NoOrderArray<String> noOrderArray;

    @org.junit.Before
    public void setUp() throws Exception {
        noOrderArray = new NoOrderArray(5);
        noOrderArray.insert("111");
        noOrderArray.insert("222");
        noOrderArray.insert("333");
        noOrderArray.insert("444");
    }

    @org.junit.Test
    public void contains() {
        assertThat(noOrderArray.contains("222"), greaterThan(0));
        assertThat(noOrderArray.contains("666"), lessThan(0));
    }

    @org.junit.Test
    public void insert() {
        noOrderArray.insert("666");
        assertThat(noOrderArray.contains("666"), greaterThan(0));
    }

    @org.junit.Test
    public void delete() {
        assertTrue(noOrderArray.delete("333"));
        assertFalse(noOrderArray.delete("666"));
    }

    @org.junit.Test
    public void display() {
        noOrderArray.display();
    }

    @Test
    public void testArray(){

        int arr2[]= new int[5];

        int[] arr= new int[5];
        int[] arr3= {1,2,3,4};

        System.arraycopy(arr3,0,arr,0,arr3.length);

        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.print(arr[i]+" ");
        }
//        arr[1],arr[i],arr[6*i]

    }
}