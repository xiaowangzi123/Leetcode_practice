package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 差的绝对值为 K 的数对数目
 */
public class Solution2006 {
    public static void main(String[] args) {
        Solution2006 obj = new Solution2006();
        System.out.println(obj.countKDifference(new int[]{1, 3, 3, 1}, 2));
        System.out.println(obj.countKDifference2(new int[]{1, 3, 3, 1}, 2));
    }

    public int countKDifference(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int countKDifference2(int[] nums, int k) {
        int[] cnt = new int[100];
        for (int num : nums) {
            cnt[num - 1]++;
        }

        int ans = 0;
        for (int i = 0; i < 100 - k; i++) {
            ans += cnt[i] * cnt[i + k];
        }
        return ans;
    }
}