package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/17
 * @description : 人口最多的年份
 */
public class Solution1854 {
    public static void main(String[] args) {
        Solution1854 obj = new Solution1854();
        int[][] logs = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        System.out.println(obj.maximumPopulation(logs));
    }

    public int maximumPopulation(int[][] logs) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int min = logs[0][0], max = 1, count = 1;

        for (int i = 1; i < logs.length; i++) {
            if (logs[i][0] < logs[i - 1][1]) {
                count++;
            } else {
                if (count > max) {
                    min = logs[i][0];
                }
                count = 1;
            }
            max = Math.max(max, count);
        }
        return min;
    }
}