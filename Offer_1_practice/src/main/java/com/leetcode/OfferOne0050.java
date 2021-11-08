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
        System.out.println(obj.firstUniqChar2("baccdeff"));
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

    /**
     * LinkedHashMap插入数据有序，可以直接遍历map查第一个出现一次的
     * HashMap无序，想找到第一个出现一次的，需要按照数组顺序进行遍历
     */
    public char firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}