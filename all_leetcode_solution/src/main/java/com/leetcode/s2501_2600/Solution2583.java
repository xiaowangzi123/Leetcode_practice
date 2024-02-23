package com.leetcode.s2501_2600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 二叉树中的第 K 大层和
 * TODO
 */
public class Solution2583 {
    public static void main(String[] args) {
        Solution2583 solution = new Solution2583();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{3,2,3,4,2};
        System.out.println(Arrays.toString(solution.distinctDifferenceArray(nums)));
        System.out.println(Arrays.toString(solution.distinctDifferenceArray(nums2)));
    }

    /**
     *
     */
    public int[] distinctDifferenceArray(int[] nums) {
        //当前锁定，不同元素的个数
        int[] count = new int[nums.length + 1];
        //记录不同的元素
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            set.add(nums[i]);
            count[i] = set.size();
        }
        int[] res = new int[nums.length];
        set.clear();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            res[i] = set.size() - count[i + 1];
        }
        return res;
    }
}
