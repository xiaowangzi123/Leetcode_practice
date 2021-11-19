package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/19
 * @description : 找出所有子集的异或总和再求和
 */
public class Solution1863 {
    public static void main(String[] args) {
        Solution1863 obj = new Solution1863();
        int[] nums = {1, 3};
        System.out.println(obj.subsetXORSum(nums));
    }

    public int subsetXORSum(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            int tmp = 0;
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) > 0) {
                    tmp ^= nums[j];
                }
            }
            ans += tmp;
        }
        return ans;
    }
}