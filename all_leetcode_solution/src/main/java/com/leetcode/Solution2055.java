package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/3/8
 * @description: TODO
 * 蜡烛之间的盘子
 */
public class Solution2055 {
    public static void main(String[] args) {
        Solution2055 obj = new Solution2055();
        int[] ans = obj.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}});
        System.out.println(Arrays.toString(ans));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }

}