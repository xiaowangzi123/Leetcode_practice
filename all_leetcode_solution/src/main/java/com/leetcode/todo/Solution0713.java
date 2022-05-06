package com.leetcode.todo;

/**
 * @author :wyq
 * @date ：Created in 2022/5/5
 * @description : TODO
 * 713. 乘积小于 K 的子数组
 */
public class Solution0713 {
    public static void main(String[] args) {
        Solution0713 obj = new Solution0713();
        System.out.println(obj.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(obj.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

    /**
     * 数组内元素均为正数，也就是乘得越多肯定越大。即便是1的话，也至少是不变，依然算是一种子数组。
     * 我们使用双指针left和right，初始阶段都指向第一个元素。接着循环枚举right，在循环的每一步中，right向右移动了一位，并将乘积乘以nums[right]。
     * 此时我们需要向右移动left，直到满足乘积小于k的条件。在每次移动时，需要将乘积除以 nums[left]。
     * 当left移动完成后，对于当前的right，就新增了right−left+1 个乘积小于k的连续子数组，即子数组的长度。
     * 那为什么是 right−left+1 个呢？这里可以举个例子，比如原来子数组是1, 2, 3，现在新加入了一个 4，那子数组个数就由 1+2+3=6 变为 1+2+3+4=10 个，即新增了 4 个。
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}