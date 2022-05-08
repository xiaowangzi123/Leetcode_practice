package com.leetcode.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2022/5/8
 * @description :
 */
public class Solution0422 {
    public static void main(String[] args) {
        Solution0422 obj = new Solution0422();
        System.out.println(obj.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            nums[index] *= -1;
            if (nums[index] > 0) {
                res.add(Math.abs(num));
            }
        }
        return res;
    }
}