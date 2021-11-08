package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/8
 * @description : 第一个只出现一次的字符
 */
public class OfferOne0050 {
    public static void main(String[] args) {
        OfferOne0050 obj = new OfferOne0050();
        System.out.println(obj.firstUniqChar(""));
        System.out.println(obj.firstUniqChar("baccdeff"));
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}