package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/14
 * @description：
 */
public class Solution0136 {
    public static void main(String[] args) {
        Solution0136 obj = new Solution0136();

        int[] arr = {1, 2, 1, 4, 2};
        System.out.println(obj.singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            return 1;
        }
        return 0;
    }
}