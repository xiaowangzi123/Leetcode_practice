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
        System.out.println(obj.removeOuterParentheses2(st));
        System.out.println("---------------");
        System.out.println(obj.removeOuterParentheses3("(()())(())"));
    }

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                count--;
            }
            if (count >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                count++;
            }
        }
        return sb.toString();
    }

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

    public String removeOuterParentheses3(String s) {
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
        LinkedList<Integer> stack = new LinkedList<>();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else {
                int temp = stack.removeLast();
                if (stack.isEmpty()) {
                    ret.append(s, temp + 1, i);
                }
            }
        }
        return ret.toString();
    }


}