package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/4
 * @description：
 */
public class Solution0053 {
    public static void main(String[] args) {
        Solution0053 obj = new Solution0053();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(nums));
        System.out.println(obj.maxSubArray2(nums));
    }


    /**
     * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 res
     * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     * 每次比较 sum 和 res的大小，将最大值置为res，遍历结束返回结果
     *
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;

    }

    /**
     * 连续最大的子序列和
     * 一个最大数加入之前，有（n-1）个相加的结果，
     */
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}