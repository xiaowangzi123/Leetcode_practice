package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/3/15
 * @description ：统计按位或能得到最大值的子集数目
 * TODO
 */
public class Solution2044 {
    public static void main(String[] args) {
        Solution2044 obj = new Solution2044();
        System.out.println(obj.countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(obj.countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(obj.countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            int orVal = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    orVal |= nums[j];
                }
            }
            if (orVal > maxOr) {
                maxOr = orVal;
                count = 1;
            } else if (orVal == maxOr) {
                count++;
            }
        }
        return count;
    }
}