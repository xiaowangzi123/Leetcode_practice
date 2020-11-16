package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/16
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5, 6, 7, 9};
        Solution obj = new Solution();
        System.out.println(obj.summaryRanges(arr));
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
                res.add(num + "");
            } else {
                res.add(num + "->" + nums[i]);
            }
            i = i + 1;
        }

        return res;
    }
}