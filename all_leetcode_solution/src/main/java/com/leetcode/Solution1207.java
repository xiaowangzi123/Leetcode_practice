package com.leetcode;

import sun.net.NetHooks;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/12
 * @description :独一无二的出现次数
 */
public class Solution1207 {
    public static void main(String[] args) {
        Solution1207 obj = new Solution1207();
//        int[] arr = {1, 2, 2, 1, 1, 3};
//        int[] arr = {1, 2};
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};

        System.out.println(obj.uniqueOccurrences(arr));
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int value:map.values()){
            if (!set.add(value)){
                return false;
            }
        }
        return true;
    }
}