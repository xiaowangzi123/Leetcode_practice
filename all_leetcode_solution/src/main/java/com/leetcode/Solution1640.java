package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :能否连接形成数组
 */
public class Solution1640 {
    public static void main(String[] args) {
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
    }

    /**
     * 1.构建HashMap，
     * key值为pieces二维数组每一行的第一个元素，value值为pieces数组的每一行值
     * 2.遍历arr数组的每一个元素
     * 2.1.map中key中不包含当前元素，则返回false
     * 2.2.map中包含当前元素，则用当前元素在map中对应的value值与arr数组比较；
     * 如果不同，返回false；
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] p : pieces) {
            map.put(p[0], p);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int[] p = map.get(arr[i]);
            for (int j = 0; j < p.length; j++) {
                if (arr[i] != p[j]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}