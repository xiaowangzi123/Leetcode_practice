package com.leetcode;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/22
 * @description：
 */
public class Solution0187 {
    public static void main(String[] args) {
        Solution0187 obj = new Solution0187();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(obj.findRepeatedDnaSequences(s));

    }

    public List<String> findRepeatedDnaSequences(String s) {
        int l = 10;
        Set<String> set = new HashSet<>(), ans = new HashSet<>();
        for (int i = 0; i < s.length() - l + 1; i++) {
            String st = s.substring(i, i + l);
            if (set.contains(st)) {
                ans.add(st);
            } else {
                set.add(st);
            }
        }
        return new ArrayList<>(ans);
    }
}