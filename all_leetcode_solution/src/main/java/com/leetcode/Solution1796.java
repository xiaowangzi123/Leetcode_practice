package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :字符串中第二大的数字
 */
public class Solution1796 {
    public static void main(String[] args) {
        Solution1796 obj = new Solution1796();
        System.out.println(obj.secondHighest("dfa12321afd"));
        System.out.println("-----------------------------");

    }

    public int secondHighest(String s) {
        int first = -1, second = -1;
        Set<Integer> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                set.add(ch - '0');
            }
        }

        for (int i : set) {
            if (first < i) {
                second = first;
                first = i;
            } else if (second < i) {
                second = i;
            }
        }
        return second;
    }
}