package com.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/20
 * @description : 删除最外层的括号
 */
public class Solution1021 {
    public static void main(String[] args) {
        Solution1021 obj = new Solution1021();
        String st = "(()())(())";
        System.out.println(obj.removeOuterParentheses(st));
        System.out.println(obj.removeOuterParentheses2(st));
        System.out.println("---------------");
        System.out.println(obj.removeOuterParentheses3("(()())(())(()(()))"));
    }

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                count--;
            }
            if (count > 0) {
                sb.append(c);
            }
            if (c == '(') {
                count++;
            }
        }
        return sb.toString();
    }

    /**
     * 跳过最外层的括号
     */
    public String removeOuterParentheses2(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (count == 1) {
                    continue;
                }
            } else {
                count--;
                if (count == 0) {
                    continue;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 1.遇到左括号(就入栈当前index
     * 2.遇到右括号)就弹出栈顶元素
     * 3.栈为空表明符合条件,截取中间对应的字符串
     */
    public String removeOuterParentheses3(String s) {
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
        LinkedList<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else {
                int index = stack.removeLast();
                if (stack.isEmpty()) {
                    sb.append(s, index + 1, i);
                }
            }
        }
        return sb.toString();
    }


}