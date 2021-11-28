package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/11/29
 * @description : 第K个最小的素数分数
 */
public class Solution0786 {
    public static void main(String[] args) {
        Solution0786 obj = new Solution0786();
        System.out.println(Arrays.toString(obj.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans.add(new int[]{arr[i], arr[j]});
            }
        }
        Collections.sort(ans, (x, y) -> x[0] * y[1] - y[0] * x[1]);
        return ans.get(k - 1);
    }
}