package com.leetcode;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/14
 * @description：
 */
public class Solution0137 {
    public static void main(String[] args) {
        Solution0137 obj = new Solution0137();
        int[] arr = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(obj.singleNumber(arr));


    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            if (en.getValue() == 1) {
                return en.getKey();
            }
        }
        return 0;
    }
}