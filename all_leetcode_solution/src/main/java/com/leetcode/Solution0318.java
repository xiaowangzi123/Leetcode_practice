package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/11/17
 * @description : 最大单词长度乘积
 */
public class Solution0318 {
    public static void main(String[] args) {
        Solution0318 obj = new Solution0318();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(obj.maxProduct(words));
    }

    public int maxProduct(String[] words) {
        int n = words.length, max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!haveCommon(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    /**
     * 有相同字母返回true
     * 没有相同字母返回false
     */
    public boolean haveCommon(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            set.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
        }
        return false;
    }

    //超时
    public boolean haveCommon2(String s1, String s2) {
        for (char c1 : s1.toCharArray()) {
            for (char c2 : s2.toCharArray()) {
                if (c1 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}