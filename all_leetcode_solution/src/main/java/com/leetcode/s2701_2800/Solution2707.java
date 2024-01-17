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
                String word = s.substring(j, i);
                //word存在于字典中时，此时d[i]=d[j]
                if (map.containsKey(word)) {
                    d[i] = Math.min(d[i], d[j]);
                }
            }
        }
        return d[n];
    }

    /**
     * 优化
     */
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


    /**
     * 递归方式
     */
    public int minExtraChar3(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
//        Map<Integer, Integer> memo = new HashMap<>();
//        return minExtraCharRecursive(s, set, s.length(), memo);
        return recursive(s, set, s.length());
    }

    /**
     * 记忆化搜索
     * @param s 字符串
     * @param dictSet 字典集合
     * @param len 当前字符串长度
     * @param resultMap 结构集合（记忆化搜索技术，避免超时）
     * @return 最小值
     */
    private int minExtraCharRecursive(String s, Set<String> dictSet, int len, Map<Integer, Integer> resultMap) {
        if (len == 0) {
            return 0;
        }

        if (resultMap.containsKey(len)) {
            return resultMap.get(len);
        }

        int minExtra = minExtraCharRecursive(s, dictSet, len - 1, resultMap) + 1;

        for (int j = len - 1; j >= 0; j--) {
            String substring = s.substring(j, len);
            if (dictSet.contains(substring)) {
                minExtra = Math.min(minExtra, minExtraCharRecursive(s, dictSet, j, resultMap));
            }
        }

        //加入结果值
        resultMap.put(len, minExtra);
        return minExtra;
    }


    /**
     * 递归没有使用记忆化技术，每次计算子串，导致最后超时
     */
    private int recursive(String s, Set<String> set, int len) {
        if (len == 0) {
            return 0;
        }

        int minExtra = recursive(s, set, len - 1) + 1;

        for (int j = len - 1; j >= 0; j--) {
            String word = s.substring(j, len);
            if (set.contains(word)) {
                minExtra = Math.min(minExtra, recursive(s, set, j));
            }
        }

        return minExtra;
    }
}
