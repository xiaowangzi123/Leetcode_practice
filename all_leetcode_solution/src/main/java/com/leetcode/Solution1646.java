package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/11
 * @description : 获取生成数组中的最大值
 */
public class Solution1646 {
    public static void main(String[] args) {
        Solution1646 obj = new Solution1646();
        System.out.println(obj.getMaximumGenerated(1));
        System.out.println(obj.getMaximumGenerated(7));
    }

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] ans = new int[n + 1];
        ans[1] = 1;
        int max = ans[1];
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                ans[i] = ans[i / 2];
            } else {
                ans[i] = ans[i / 2] + ans[i / 2 + 1];
            }
            max = Math.max(max, ans[i]);
        }

//        return Arrays.stream(ans).max().getAsInt();
        return max;
    }
}