package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description :
 */
public class Solution0423 {
    public static void main(String[] args) {
        Solution0423 obj = new Solution0423();
        System.out.println(obj.originalDigits("owoztneoer"));
        System.out.println(obj.originalDigits2("owoztneoer"));
        System.out.println(obj.originalDigits("fviefuro"));
        System.out.println(obj.originalDigits2("fviefuro"));
    }

    /**
     * 字母	数字
     * e	0 1 3 5 7 8 9
     * f	4 5
     * g	8
     * h	3 8
     * i	5 6 8 9
     * n	1 7 9
     * o	0 1 2 4
     * r	0 3 4
     * s	6 7
     * t	2 3 8
     * u	4
     * v	5 7
     * w	2
     * x	6
     * z	0
     */
    public String originalDigits(String s) {
        int[] count = new int[26], num = new int[10];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        num[0] = count['z' - 'a'];
        num[2] = count['w' - 'a'];
        num[4] = count['u' - 'a'];
        num[6] = count['x' - 'a'];
        num[8] = count['g' - 'a'];
        num[3] = count['h' - 'a'] - num[8];
        num[5] = count['f' - 'a'] - num[4];
        num[7] = count['s' - 'a'] - num[6];
        num[1] = count['o' - 'a'] - num[0] - num[2] - num[4];
        num[9] = count['i' - 'a'] - num[5] - num[6] - num[8];

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < num[i]; j++) {
                ans.append(i);
            }
        }
        return ans.toString();
    }

    public String originalDigits2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int[] num = new int[10];
        num[0] = map.getOrDefault('z', 0);
        num[2] = map.getOrDefault('w', 0);
        num[4] = map.getOrDefault('u', 0);
        num[6] = map.getOrDefault('x', 0);
        num[8] = map.getOrDefault('g', 0);
        num[3] = map.getOrDefault('h', 0) - num[8];
        num[5] = map.getOrDefault('f', 0) - num[4];
        num[7] = map.getOrDefault('s', 0) - num[6];
        num[1] = map.getOrDefault('o', 0) - num[0] - num[2] - num[4];
        num[9] = map.getOrDefault('i', 0) - num[5] - num[6] - num[8];

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < num[i]; j++) {
                ans.append(i);
            }
        }
        return ans.toString();
    }
}