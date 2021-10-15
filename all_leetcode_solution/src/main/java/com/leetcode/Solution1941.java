package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/15
 * @description : 重新分配字符使所有字符串都相等
 */
public class Solution1941 {
    public static void main(String[] args) {
        Solution1941 obj = new Solution1941();
        String s = "abacbc";

        System.out.println(obj.areOccurrencesEqual(s));
        System.out.println(obj.areOccurrencesEqual2(s));
    }

    public boolean areOccurrencesEqual(String s) {
        int temp = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            temp = map.getOrDefault(ch, 0);
        }
        for (int i : map.values()) {
            if (i != temp) {
                return false;
            }
        }
        return true;
    }

    public boolean areOccurrencesEqual2(String s) {
        int[] count = new int[26];
        int temp = 0;
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
            temp = Math.max(temp, count[ch - 'a']);
        }

        for (int i=0;i<26;i++){
            if (count[i]>0 && count[i]!=temp){
                return false;
            }
        }

        return true;
    }
}