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
        int[] arr = {0, 1, 1};
        System.out.println(obj.prefixesDivBy5(arr));
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        String st = "";
        for (int i : nums) {
            st += i;
            int temp = Integer.valueOf(st, 2);
            if (temp % 5 == 0) {
                ans.add(i, true);
            }else {
                ans.add(i,false);
            }
        }
        return ans;
    }
}