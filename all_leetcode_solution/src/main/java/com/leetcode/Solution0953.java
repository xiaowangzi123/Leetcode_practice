package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0953 {
    public static void main(String[] args) {
        Solution0953 obj = new Solution0953();
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(obj.isAlienSorted(words, order));

    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int n = order.length();
        for (int i = 0; i < n; i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrder(words[i], words[i + 1], map)) {
                return false;
            }
        }
        return true;
    }

    public boolean isOrder(String s1, String s2, Map<Character, Integer> map) {
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            if (map.get(s1.charAt(i)) < map.get(s2.charAt(i))) {
                return true;
            } else if (map.get(s1.charAt(i)) > map.get(s2.charAt(i))) {
                return false;
            }
            if (i == length - 1 && s1.length() > s2.length()) {
                return false;
            }
        }
        return true;
    }
}