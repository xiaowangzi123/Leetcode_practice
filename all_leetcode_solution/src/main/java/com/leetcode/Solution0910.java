package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/1/15
 * @description: 最小差值 II
 */
public class Solution0910 {
    public static void main(String[] args) {
        Solution0910 obj = new Solution0910();
        System.out.println(obj.smallestRangeII(new int[]{1}, 0));
        System.out.println(obj.smallestRangeII(new int[]{0, 10}, 2));
        System.out.println(obj.smallestRangeII(new int[]{1, 3, 6}, 3));
    }

    /**
     * 数组首先排序，如果整体都加k或者都减去k，最小的差值是ans=nums[n-1]-nums[0]
     * 如果从0-i的元素减少k,从i到n-1的元素都加k，则最小的差值是ans+k*2，不符合题目要求最小
     * 考虑从0-i的元素加k,从i到n-1的元素都减去k，
     * 遍历截取节点，从0到n-2,
     * 最大值取nums[n - 1] - k, nums[i] + k之一
     * 最小值取nums[0] + k, nums[i + 1] - k之一
     */
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(nums[n - 1] - k, nums[i] + k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}