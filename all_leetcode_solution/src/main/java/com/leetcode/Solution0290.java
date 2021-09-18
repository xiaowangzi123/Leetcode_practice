package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description：
 */
public class Solution0290 {
    public static void main(String[] args) {
        Solution0290 obj = new Solution0290();
        String pattern = "abba", str = "dog dog dog dog";
        System.out.println(obj.wordPattern(pattern,str));
    }
    /**
     *
     */
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] str = s.split(" ");
        for (int i = 0; i < pattern.length(); i++) {
            char sChar = s.charAt(i);
            String st = str[i];
            if (!map.containsKey(sChar)) {
                if (map.containsValue(st)) {
                    return false;
                }
                map.put(sChar, st);
            } else {
                if (st != map.get(sChar)) {
                    return false;
                }
            }
        }
        return true;
    }

}