package com.leetcode.s0201_0300;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间汇总
 */
public class Solution0228 {
    public static void main(String[] args) {
        Solution0228 obj = new Solution0228();
        int[] arr = {0, 1, 2, 3, 5, 6, 7, 9};
        int[] arr2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(obj.summaryRanges(arr));
        System.out.println(obj.summaryRanges(arr2));


    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int num = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num == nums[i]) {
                res.add(String.valueOf(num));
            } else {
                res.add(num + "->" + nums[i]);
            }
            i++;
        }

        return res;
    }
}