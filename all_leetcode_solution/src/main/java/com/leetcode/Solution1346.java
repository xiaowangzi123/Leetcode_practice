package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :检查整数及其两倍数是否存在
 */
public class Solution1346 {
    public static void main(String[] args) {
        Solution1346 obj = new Solution1346();
//        int[] arr = {10,2,5,3};
        int[] arr = {7, 1, 14, 11};
        System.out.println(obj.checkIfExist(arr));

    }

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i] * 2, i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) != i) {
                return true;
            }
        }
        return false;
    }
}