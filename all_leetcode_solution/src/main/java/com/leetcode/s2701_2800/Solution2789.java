package com.leetcode.s2701_2800;

/**
 * 合并后数组中的最大元素
 */
public class Solution2789 {
    public static void main(String[] args) {
        Solution2789 solution = new Solution2789();
        int[] nums = {2, 3, 7, 9, 3};
        System.out.println(solution.maxArrayValue(nums));
        System.out.println(solution.maxArrayValue(new int[]{5, 3, 3}));

    }

    /**
     * 题目中的一次替换删除操作，其实是相当于将两个相邻并且非递减的数字进行求和合并。
     * 两个数字的和来替换掉原来的两个数字。
     * 而经过若干次这样的合并，整个数组的和是不变的。
     * 合并后数组中的每个元素，都是原数组的某个子数组的和，并且这些子数组拼接起来能构成整个原数组。
     * 为了使数组的最大值最大，我们可以贪心地做尽可能多的合并，直到整个数组都不能进行合并。
     * 合并的要求是后面的数字不小于前面的数字，我们就尽可能先合并靠后的数字，使其尽快能大，才能够合并前面的数字。
     */
    public long maxArrayValue(int[] nums) {
        long sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? nums[i] + sum : nums[i];
        }
        return sum;
    }
}
