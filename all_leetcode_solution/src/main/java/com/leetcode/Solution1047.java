package com.leetcode;

import java.util.ArrayDeque;

/**
 * @author :wyq
 * @date ：Created in 2021/10/30
 * @description : 删除字符串中的所有相邻重复项
 */
public class Solution1047 {
    public static void main(String[] args) {
        Solution1047 obj = new Solution1047();
        String s = "abbaca";
        System.out.println(obj.removeDuplicates(s));
        System.out.println(obj.removeDuplicates2(s));
    }

    public String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char i : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == i) {
                stack.pollLast();
            } else {
                stack.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch:stack){
            sb.append(ch);
        }
        return sb.toString();
    }

    public String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (sb.length()>0 && sb.charAt(sb.length()-1)==i) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}