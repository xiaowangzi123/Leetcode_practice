package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/12/8
 * @description : 三个无重叠子数组的最大和
 * 滑动窗口
 */
public class Solution0689 {
    public static void main(String[] args) {
        Solution0689 obj = new Solution0689();
        System.out.println(Arrays.toString(obj.maxSumOfOneSubarrays(new int[]{1, 2, 3, 5, 2, 7}, 3)));
        System.out.println(Arrays.toString(obj.maxSumOfTwoSubarrays(new int[]{1, 2, 4, 3, 2, 6, 4, 2, 1, 1}, 2)));
        System.out.println(Arrays.toString(obj.maxSumOfThreeSubarrays(new int[]{1, 2, 4, 3, 2, 6, 4, 2, 1, 6, 2, 7}, 2)));
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

    /**
     * 使用三个大小为k的滑动窗口。设sum1为第一个滑动窗口的元素和，该滑动窗口从[0,k−1]开始；
     * sum2为第二个滑动窗口的元素和，该滑动窗口从[k,2k−1]开始；
     * sum3为第三个滑动窗口的元素和，该滑动窗口从[2k,3k−1]开始。
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int sum1 = 0, max1 = 0, index1 = 0;
        int sum2 = 0, max12 = 0, index11 = 0, index12 = 0;
        int sum3 = 0, maxSum = 0;
        for (int i = k * 2; i < nums.length; ++i) {
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= k * 3 - 1) {
                if (sum1 > max1) {
                    max1 = sum1;
                    index1 = i - k * 3 + 1;
                }
                if (max1 + sum2 > max12) {
                    max12 = max1 + sum2;
                    index11 = index1;
                    index12 = i - k * 2 + 1;
                }
                if (max12 + sum3 > maxSum) {
                    maxSum = max12 + sum3;
                    ans[0] = index11;
                    ans[1] = index12;
                    ans[2] = i - k + 1;
                }
                sum1 -= nums[i - k * 3 + 1];
                sum2 -= nums[i - k * 2 + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return ans;
    }


}