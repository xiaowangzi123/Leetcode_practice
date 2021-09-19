package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/19
 * @description：
 */
public class Solution0409 {
    public static void main(String[] args) {
        Solution0409 obj = new Solution0409();
        String s = "ajelkjakljez";
        System.out.println(obj.longestPalindrome(s));
        System.out.println(obj.longestPalindrome2(s));
        System.out.println(obj.longestPalindrome3(s));

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 23);
        System.out.println(map);
        map.put('a', map.get('a') + 1);
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
        int count = 0;
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            count += (entry.getValue() / 2) * 2;
        }
        if (count != s.length()) {
            count++;
        }
        return count;
    }

    //大小写字母中间有6个字符
    public int longestPalindrome2(String s) {
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            count[c - 'A'] += 1;
        }
        int res = 0;
        for (int i : count) {
            res += (i / 2) * 2;
        }
        return res < s.length() ? res + 1 : res;
    }

    //'z'值122，初始化时数组大小选择123
    public int longestPalindrome3(String s){
        int[] count = new int[123];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int res = 0;
        for (int i : count) {
            res += (i / 2) * 2;
        }
        return res < s.length() ? res + 1 : res;
    }
}