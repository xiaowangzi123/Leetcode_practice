package com.leetcode;

import org.junit.Test;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/11
 * @description：
 */
public class Solution {

    @Test
    public void test1() {
        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        Solution obj = new Solution();
        System.out.println(obj.findMaxConsecutiveOnes(arr));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                res = Math.max(res, count);
            } else count = 0;
        }
        return res;
    }
}