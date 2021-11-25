package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: wyq
 * @create time: 2021/11/25
 * @description: 检查两个字符串是否几乎相等
 */
public class Solution2068 {
    public static void main(String[] args) {
        Solution2068 obj = new Solution2068();
        System.out.println(obj.checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println(obj.checkAlmostEquivalent("abcdeef", "abaaacc"));
        System.out.println(obj.checkAlmostEquivalent("cccddabba", "babababab"));

    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] w1 = new int[26], w2 = new int[26];
        for (char c : word1.toCharArray()) {
            w1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            w2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(w1[i] - w2[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}