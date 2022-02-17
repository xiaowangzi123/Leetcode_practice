package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :仅执行一次字符串交换能否使两个字符串相等
 */
public class Solution1791 {
    public static void main(String[] args) {
        Solution1791 obj = new Solution1791();
    }

    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] cnt = new int[n + 1];
        for (int[] edge : edges) {
            cnt[edge[0]]++;
            cnt[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == n - 1) {
                return i;
            }
        }
        return 0;
    }


}