package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0961 {
    public static void main(String[] args) {
        Solution0961 obj = new Solution0961();
        int[] arr = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(obj.repeatedNTimes(arr));

    }

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }


}