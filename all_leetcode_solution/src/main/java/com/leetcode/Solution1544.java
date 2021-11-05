package com.leetcode;

import java.lang.reflect.Array;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author :wyq
 * @date ：Created in 2021/11/4
 * @description : 整理字符串
 */
public class Solution1544 {
    public static void main(String[] args) {
        Solution1544 obj = new Solution1544();
        System.out.println(obj.makeGood("leEeetcode"));
        System.out.println(obj.makeGood2("leEeetcode"));
        System.out.println('a' == 'A' + 32);
    }

    public String makeGood(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char temp = stack.peekLast();
                if ((temp != ch) && (temp == (ch + 32) || temp == (ch - 32))) {
                    stack.pollLast();
                } else {
                    stack.add(ch);
                }
            } else {
                stack.add(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }

    public String makeGood2(String s) {
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ans.length() > 0) {
                char temp = ans.charAt(ans.length() - 1);
                if (temp != ch && (temp == (ch + 32) || temp == (ch - 32))) {
                    ans.deleteCharAt(ans.length() - 1);
                } else {
                    ans.append(ch);
                }
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}