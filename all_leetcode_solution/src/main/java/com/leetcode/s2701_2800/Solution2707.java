package com.leetcode.s2701_2800;

import java.util.*;

/**
 * @author wyq
 * @date 2024/1/12
 * @desc 字符串中的额外字符串
 */
public class Solution2707 {
    public static void main(String[] args) {
        Solution2707 solution = new Solution2707();
        String s = "leetscleetode";
        String[] dictionary = new String[]{"leet", "code", "leetcode"};
        System.out.println(solution.minExtraChar2(s, dictionary));
        System.out.println(solution.minExtraChar3(s, dictionary));
    }

    /**
     * 动态规划求解
     */
    public int minExtraChar(String s, String[] dictionary) {

        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        //对字典单词出现的次数没有限制，此处可以使用set
        Map<String, Integer> map = new HashMap<>();
        for (String str : dictionary) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            //第一种切分方式
            d[i] = d[i - 1] + 1;
            //第二种切分方式，两者取最小值
            for (int j = i - 1; j >= 0; j--) {
                if (map.containsKey(s.substring(j, i))) {
                    d[i] = Math.min(d[i], d[j]);
                }
            }
        }
        return d[n];
    }

    public int minExtraChar2(String s, String[] dictionary) {

        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        Set<String> set = new HashSet<>();
        Collections.addAll(set, dictionary);
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(s.substring(j, i))) {
                    d[i] = Math.min(d[i], d[j]);
                }
            }
        }
        return d[n];
    }


    public int minExtraChar3(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        Map<Integer, Integer> memo = new HashMap<>();
        return minExtraCharRecursive(s, set, s.length(), memo);
    }

    private int minExtraCharRecursive(String s, Set<String> set, int end, Map<Integer, Integer> memo) {
        if (end == 0) {
            return 0;
        }

        if (memo.containsKey(end)) {
            return memo.get(end);
        }

        int minExtra = minExtraCharRecursive(s, set, end - 1, memo) + 1;

        for (int j = end - 1; j >= 0; j--) {
            String substring = s.substring(j, end);
            if (set.contains(substring)) {
                minExtra = Math.min(minExtra, minExtraCharRecursive(s, set, j, memo));
            }
        }

        memo.put(end, minExtra);
        return minExtra;
    }

}
