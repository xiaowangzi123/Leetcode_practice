package com.leetcode.backtrace;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: wyq
 * @create time: 2022/1/18
 * @description: 拆分字符串使唯一子字符串的数目最大
 */
public class Solution1593 {
    public static void main(String[] args) {
        Solution1593 obj = new Solution1593();
//        System.out.println(obj.maxUniqueSplit("aa"));
        System.out.println(obj.maxUniqueSplit("abaa"));
//        System.out.println(obj.maxUniqueSplit("ababccc"));
    }

    /**
     * 回溯
     */
    private int max = 1;

    public int maxUniqueSplit(String s) {
        dfs(s, 0, new HashSet<>());
        return max;
    }

    public void dfs(String s, int index, Set<String> set) {
        if (index == s.length()) {
            max = Math.max(max, set.size());
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (set.contains(sub)) {
                continue;
            }
            set.add(sub);
            dfs(s, i, set);
            set.remove(sub);
        }
    }
}