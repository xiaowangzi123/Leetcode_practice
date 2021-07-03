package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution0020 {
    public static void main(String[] args) {
        Solution0020 obj = new Solution0020();
        String s1 = "()[]{}";
        System.out.println(obj.isValid(s1));

        Map<String, Character> map = new HashMap<>();
        map.put("s", 's');
        System.out.println(map);
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }


}