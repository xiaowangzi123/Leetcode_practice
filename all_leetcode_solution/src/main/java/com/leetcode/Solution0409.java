package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/19
 * @description：
 */
public class Solution0409 {
    public static void main(String[] args) {
        Solution0409 obj = new Solution0409();
        String s = "ajelkjaklje";
        System.out.println(obj.longestPalindrome(s));

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 23);
        System.out.println(map);
        map.put('a', map.get('a')+1);
        System.out.println(map);
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return 0;
    }
}