package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/18
 * @description : 增减字符串匹配
 */
public class Solution0942 {
    public static void main(String[] args) {
        Solution0942 obj = new Solution0942();
        System.out.println(Arrays.toString(obj.diStringMatch("IDID")));
    }

    public int[] diStringMatch(String s) {
        int n = s.length(), min = 0, max = n + 1;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if ('I' == s.charAt(i)) {
                ans[i] = min++;
            }
            if ('D' == s.charAt(i)) {
                ans[i] = max--;
            }
        }
        ans[n] = min;
        return ans;
    }
}