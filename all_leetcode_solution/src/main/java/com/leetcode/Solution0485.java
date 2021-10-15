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
        System.out.println(obj.findMaxConsecutiveOnes2(arr));

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = 0, start = 0, index = 0;
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

    public int findMaxConsecutiveOnes2(int[] nums) {
        int res = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res;
    }
}