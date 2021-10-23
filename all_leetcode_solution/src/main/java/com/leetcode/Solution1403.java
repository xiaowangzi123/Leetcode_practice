package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/23
 * @description : 非递增顺序的最小子序列
 */
public class Solution1403 {
    public static void main(String[] args) {
        Solution1403 obj = new Solution1403();
        int[] arr = {4, 3, 10, 9, 8};
        System.out.println(obj.minSubsequence(arr));
    }

    /**
     * 最小子序列之和大于剩余元素之和
     * 要求元素之和最大，长度最短
     * 所以应该选择较大的数，才能满足和最大的同时，所需要的元素数最少
     */
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0, sum1 = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(nums[i]);
            sum1 += nums[i];
            if (sum1 * 2 > sum) {
                break;
            }
        }
        return ans;
    }
}