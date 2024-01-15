package com.leetcode.s0001_0100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyq
 * @date 2024/1/15
 * @desc 回旋镖的数量
 */
public class Solution0447 {
    public static void main(String[] args) {
        Solution0447 solution = new Solution0447();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(solution.numberOfBoomerangs(points));
    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] x : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] y : points) {
                int dis = (int) (Math.pow((x[0] - y[0]), 2) + Math.pow((x[1] - y[1]), 2));
//                int dis = (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                ans += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return ans;

    }
}
