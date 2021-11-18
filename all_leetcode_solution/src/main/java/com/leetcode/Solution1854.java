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
//        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int index = 0, max = 0, count = 0;

        int[] arr = new int[101];
        for (int[] log : logs) {
            arr[log[0] - 1950]++;
            arr[log[1] - 1950]--;
        }

        for (int i = 0; i < 101; i++) {
            count += arr[i];
            if (count > max) {
                max = count;
                index = i;
            }
        }
        return index + 1950;
    }
}