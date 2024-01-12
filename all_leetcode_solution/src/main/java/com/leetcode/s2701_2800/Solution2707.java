package com.leetcode.s2701_2800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wyq
 * @date 2024/1/12
 * @desc 字符串中的额外字符串
 */
public class Solution2707 {
    public static void main(String[] args) {


    }

    public int minExtraChar(String s, String[] dictionary) {

        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : dictionary) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (map.containsKey(s.substring(j, i))) {
                    d[i] = Math.min(d[i], d[j]);
                }
            }
        }
        return d[n];
    }
}
