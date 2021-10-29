package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/30
 * @description : 只出现一次的数字 III
 */
public class Solution0260 {
    public static void main(String[] args) {
        Solution0260 obj = new Solution0260();
        int[] arr = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(obj.singleNumber(arr)));
    }

    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans[i] = entry.getKey();
                i++;
            }
        }
        return ans;
    }
}