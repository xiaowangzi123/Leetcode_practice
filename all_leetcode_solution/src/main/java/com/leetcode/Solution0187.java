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
        System.out.println(obj.findRepeatedDnaSequences2(s));

        String s2 = "AAAAAAAAAAA";
        System.out.println(obj.findRepeatedDnaSequences(s2));
        System.out.println(obj.findRepeatedDnaSequences2(s2));

        System.out.println("-------------------");
        System.out.println(s2.substring(0, 10));

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

    public List<String> findRepeatedDnaSequences2(String s) {
        int l = 10;
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - l + 1; i++) {
            String temp = s.substring(i, i + l);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (map.get(temp) == 2) {
                ans.add(temp);
            }
        }
        return ans;
    }
}