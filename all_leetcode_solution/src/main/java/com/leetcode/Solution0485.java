package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/15
 * @description :最大连续 1 的个数
 */
public class Solution0485 {
    public static void main(String[] args) {
        Solution0485 obj = new Solution0485();
        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println(obj.findMaxConsecutiveOnes(arr));

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = 0;
        int start = 0, index = 0;
        while (index < nums.length) {
            if (nums[index] == 1) {
                index++;
                temp = Math.max(temp, index - start);
            } else {
                index++;
                start = index;
            }
        }
        return temp;
    }
}