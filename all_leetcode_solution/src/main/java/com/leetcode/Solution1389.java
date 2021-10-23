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
        System.out.println(Arrays.toString(obj.createTargetArray2(nums, index)));
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

    public int[] createTargetArray2(int[] nums, int[] index) {
        int n = index.length;
        int[] ans = new int[n];
        for (int i = 0; i < index.length; i++) {
            //如果有插入的情况
            if (index[i] < i) {
                //数组整体后移一位
                for (int j = n - 1; j > index[i]; j--) {
                    ans[j] = ans[j - 1];
                }
                //插入当前值
                ans[index[i]] = nums[i];
            } else {
                ans[i] = nums[i];
            }
        }
        return ans;
    }
}