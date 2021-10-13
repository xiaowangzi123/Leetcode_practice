package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :统计最大组的数目
 */
public class Solution1399 {
    public static void main(String[] args) {
        Solution1399 obj = new Solution1399();
        System.out.println(obj.countLargestGroup(2));
        System.out.println(obj.countLargestGroup(13));
        System.out.println(obj.countLargestGroup(15));

        System.out.println("-------------------------");
    }

    public int countLargestGroup(int n) {
        int max = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            //错误，需要修改TODO
            int temp = i % 9;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            max = Math.max(max, map.get(temp));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                count++;
            }
        }
        return count;
    }


}