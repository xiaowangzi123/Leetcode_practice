package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/14
 * @description：
 */
public class Solution0169 {
    public static void main(String[] args) {
        Solution0169 obj = new Solution0169();
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int[] arr2 = {3, 3, 4};
        System.out.println(obj.majorityElement(arr));
        System.out.println(obj.majorityElement(arr2));
    }

    public int majorityElement(int[] nums) {
        int res = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (max < entry.getValue()) {
                max = Math.max(max, entry.getValue());
                res = entry.getKey();
            }
        }

        return res;
    }
}