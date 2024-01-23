package com.leetcode.s2701_2800;

/**
 * 最长交替子数组
 */
public class Solution2765 {
    public static void main(String[] args) {
        Solution2765 solution = new Solution2765();
        int[] nums = {2, 3, 4, 3, 4};
        int[] nums2 = {4, 5, 6};
        System.out.println(solution.alternatingSubarray(nums));
        System.out.println(solution.alternatingSubarray(nums2));
    }

    /**
     * 利用的是nums[k]-nums[j]=Math.pow(-1, count + 1)
     */
    public int alternatingSubarray(int[] nums) {
        int max = -1;
        int count = 1;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i, k = j + 1; k < len; j++, k++) {
                if (nums[k] - nums[j] == Math.pow(-1, count + 1)) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(max, count);
            count = 1;
            // 如果最长交替数组大于剩余数组长度，则直接返回（有一点点提升）
            if (len - i <= max) {
                return max;
            }
        }
        //max==1说明没有符合条件的子序列
        return max == 1 ? -1 : max;
    }

    /**
     * 利用的交替子序列，同奇同偶时数据相同，一奇一偶时加一
     */
    public int alternatingSubarray2(int[] nums) {
        int res = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //同奇同偶时数据相同，一奇一偶时加一
                if (nums[j] - nums[i] == (j - i) % 2) {
                    res = Math.max(res, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return res;
    }


}
