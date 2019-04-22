package com.github.bjlhx15.datastructure.algorithm.stack;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/21 下午3:13
 */
public class StackWithArrayTest {

    @Test
    public void breaketTrue() {
        String in="a{b(c[d]e)f}";
        BreaketChecker breaketChecker=new BreaketChecker(in);
        assertTrue(breaketChecker.check());
    }
    @Test
    public void breaketFalse() {
        String in="a{b(c[d])e)f}";
        BreaketChecker breaketChecker=new BreaketChecker(in);
        assertFalse(breaketChecker.check());
    }

    @Test
    public void javaStack() {
        Stack<Long> a =new Stack<>();
        String in="a{b(c[d])e)f}";
        BreaketChecker breaketChecker=new BreaketChecker(in);
        assertFalse(breaketChecker.check());
    }
}