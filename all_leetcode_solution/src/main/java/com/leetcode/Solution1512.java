package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :好数对的数目
 */
public class Solution1512 {
    public static void main(String[] args) {
        Solution1512 obj = new Solution1512();
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(obj.numIdenticalPairs(nums));
    }


    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}