package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/12/8
 * @description : 三个无重叠子数组的最大和
 */
public class Solution0689 {
    public static void main(String[] args) {
        Solution0689 obj = new Solution0689();
        System.out.println(Arrays.toString(obj.maxSumOfOneSubarrays(new int[]{1, 2, 3, 5, 2, 7}, 3)));
        System.out.println(Arrays.toString(obj.maxSumOfTwoSubarrays(new int[]{1, 2, 4, 3, 2, 6, 4, 2}, 2)));
    }


    /**
     * 数组的一个k个元素的最大连续子序列
     */
    public int[] maxSumOfOneSubarrays(int[] nums, int k) {
        int[] ans = new int[1];
        int sum1 = 0, max1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            if (i >= k - 1) {
                if (sum1 > max1) {
                    max1 = sum1;
                    ans[0] = i - k + 1;
                }
                sum1 -= nums[i - k + 1];
            }
        }
        return ans;
    }

    /**
     * 数组的两个k个元素的最大连续子序列
     */
    public int[] maxSumOfTwoSubarrays(int[] nums, int k) {
        int[] ans = new int[2];
        int sum1 = 0, max1 = 0, index1 = 0;
        int sum2 = 0, sum = 0;
        for (int i = k; i < nums.length; i++) {
            sum1 += nums[i - k];
            sum2 += nums[i];
            if (i >= k * 2 - 1) {
                if (sum1 > max1) {
                    max1 = sum1;
                    index1 = i - k * 2 + 1;
                }
                if (max1 + sum2 > sum) {
                    sum = max1 + sum2;
                    ans[0] = index1;
                    ans[1] = i - k + 1;
                }
                sum1 -= nums[i - k * 2 + 1];
                sum2 -= nums[i - k + 1];
            }
        }
        return ans;
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];

        return ans;
    }


}