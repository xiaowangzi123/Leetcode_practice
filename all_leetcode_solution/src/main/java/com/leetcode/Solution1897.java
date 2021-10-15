package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/15
 * @description : 重新分配字符使所有字符串都相等
 */
public class Solution1897 {
    public static void main(String[] args) {
        Solution1897 obj = new Solution1897();
        String[] words = {"abc", "aabc", "bc"};

        System.out.println(obj.makeEqual(words));
        System.out.println(obj.makeEqual2(words));

    }

    public boolean makeEqual(String[] words) {
        int n = words.length;
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % n != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean makeEqual2(String[] words) {
        int[] count = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                count[ch-'a']++;
            }
        }
        for (int i=0;i<26;i++){
            if (count[i]%words.length!=0){
                return false;
            }
        }
        return true;
    }
}