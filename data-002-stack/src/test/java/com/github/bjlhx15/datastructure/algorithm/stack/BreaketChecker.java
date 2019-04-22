package com.github.bjlhx15.datastructure.algorithm.stack;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/java-data-structure-algorithm)
 * @since 2019/4/21 下午3:21
 */
public class BreaketChecker {
    private String input;

    public BreaketChecker(String input) {
        this.input = input;
    }

    public boolean check() {
        int length = input.length();
        StackWithArray<Character> stackWithArray = new StackWithArray(length);

        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stackWithArray.push(ch);
                    continue;
                case '}':
                case ']':
                case ')':
                    if (!stackWithArray.isEmpty()) {
                        Character character = stackWithArray.pop();//左侧
                        if ((character == '{' && ch != '}') ||
                                (character == '[' && ch != ']') ||
                                (character == '(' && ch != ')')) {
                            System.out.println("匹配出错，字符是" + ch + "，下标：" + i);
                            return false;
                        }
                    }
                    continue;
                default:
                    continue;

            }

        }
        if (!stackWithArray.isEmpty()) {
            System.out.println("匹配出错，有未关闭的括号");
            return false;
        }
        return true;

    }
}
