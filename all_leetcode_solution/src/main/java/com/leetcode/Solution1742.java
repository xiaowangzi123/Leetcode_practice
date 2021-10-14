package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :盒子中小球的最大数量
 */
public class Solution1742 {
    public static void main(String[] args) {
        Solution1742 obj = new Solution1742();

        int lowLimit = 1, highLimit = 10;
        System.out.println(obj.countBalls(lowLimit, highLimit));
    }


    public int countBalls(int lowLimit, int highLimit) {
        int max = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int temp = 0, k = i;
            while (k > 0) {
                temp += k % 10;
                k /= 10;
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            max = Math.max(max, map.get(temp));
        }

        /*for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                count++;
            }
        }*/
        return max;
    }

}