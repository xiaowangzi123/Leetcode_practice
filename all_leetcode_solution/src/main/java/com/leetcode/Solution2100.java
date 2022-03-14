package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2022/3/6
 * @description: TODO
 * 子数组范围和
 */
public class Solution2100 {
    public static void main(String[] args) {
        Solution2100 obj = new Solution2100();
        System.out.println(obj.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
        System.out.println(obj.goodDaysToRobBank(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(obj.goodDaysToRobBank(new int[]{1, 2, 3, 4, 5, 6}, 2));
    }

    /**
     *  left[i]：第i天前警卫数目连续非递增的天数，有初始调试left[0]=0
     *  right[i]: 第i天后警卫数目连续非递减的天数,有right[n-1]=0
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[n - i - 1] <= security[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
    }
}