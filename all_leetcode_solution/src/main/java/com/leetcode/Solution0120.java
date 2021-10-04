package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/9
 * @description :三角形最小路径和
 */
public class Solution0120 {
    public static void main(String[] args) {
        Solution0120 obj = new Solution0120();
//        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
//        List<List<Integer>> triangle = new ArrayList<>();


        List<Integer> list = new ArrayList<Integer>() {{
            add(2);
        }};
        List<Integer> list2 = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};
        List<Integer> list3 = new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }};
        List<Integer> list4 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};

        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {
            {
                add(list);
                add(list2);
                add(list3);
                add(list4);
            }
        };


        System.out.println(obj.minimumTotal(triangle));
    }

    /**
     *
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + cur.get(j);
            }
        }
        return dp[0][0];
    }


    public int minimumTotal2(List<List<Integer>> triangle) {

    }
}