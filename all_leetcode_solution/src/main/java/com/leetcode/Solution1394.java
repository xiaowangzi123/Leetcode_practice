package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :找出数组中的幸运数
 */
public class Solution1394 {
    public static void main(String[] args) {
        Solution1394 obj = new Solution1394();
//        int[] arr = {2, 2, 3, 4};
//        int[] arr = {2, 2, 2, 3, 3};
        int[] arr = {1, 2, 2, 3, 3, 3};
        System.out.println(obj.findLucky(arr));
        System.out.println(obj.findLucky2(arr));


        System.out.println("-------------------------");
    }

    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //返回最大的
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                max = Math.max(max, entry.getKey());
            }
        }
        return max;
    }

    public int findLucky2(int[] arr) {
        int[] count = new int[501];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 500; i >= 0; i--) {
            if (count[i] == i) {
                return i;
            }
        }
        return -1;
    }
}