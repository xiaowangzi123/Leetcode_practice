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
    }

    public String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char i : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast()==i){
                stack.pollLast();
            }else {
                stack.add(i);
            }
        }
        return stack.toString();
    }
}