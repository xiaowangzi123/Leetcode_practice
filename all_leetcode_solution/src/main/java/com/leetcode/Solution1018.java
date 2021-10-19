package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/19
 * @description : 可被 5 整除的二进制前缀
 */
public class Solution1018 {
    public static void main(String[] args) {
        Solution1018 obj = new Solution1018();
//        int[] arr = {0, 1, 1};
        int[] arr = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        System.out.println(obj.prefixesDivBy52(arr));
    }

    //java.lang.NumberFormatException
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        String st = "";
        for (int i = 0; i < nums.length; i++) {
            st += nums[i];
            int temp = Integer.valueOf(st, 2);
            if (temp % 5 == 0) {
                ans.add(i, true);
            } else {
                ans.add(i, false);
            }
        }
        return ans;
    }

    public List<Boolean> prefixesDivBy52(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int remainder = 0;
        for (int i = 0; i < nums.length; i++) {
            remainder = (remainder * 2 + nums[i]) % 5;
            ans.add(remainder == 0);
        }
        return ans;
    }
}