package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/23
 * @description : 按既定顺序创建目标数组
 */
public class Solution1389 {
    public static void main(String[] args) {
        Solution1389 obj = new Solution1389();
        int[] nums = {0, 1, 2, 3, 4}, index = {0, 1, 2, 2, 1};
        System.out.println(Arrays.toString(obj.createTargetArray(nums, index)));
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int n = index.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(index[i], nums[i]);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}