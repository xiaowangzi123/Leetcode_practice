package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/22
 * @description : 有序数组中出现次数超过25%的元素
 */
public class Solution1287 {
    public static void main(String[] args) {
        Solution1287 obj = new Solution1287();
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(obj.findSpecialInteger(arr));
    }

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 4) {
                return entry.getKey();
            }
        }
        return -1;
    }
}