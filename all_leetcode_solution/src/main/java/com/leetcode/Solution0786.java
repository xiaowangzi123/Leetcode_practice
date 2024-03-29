package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/11/29
 * @description : 第K个最小的素数分数
 */
public class Solution0786 {
    public static void main(String[] args) {
        Solution0786 obj = new Solution0786();
        System.out.println(Arrays.toString(obj.kthSmallestPrimeFraction2(new int[]{1, 2, 3, 5}, 3)));
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


    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        int n = arr.length;
        double left = 0.0, right = 1.0;
        while (true) {
            double mid = (left + right) / 2;
            int i = -1, count = 0;
            // 记录最大的分数
            int x = 0, y = 1;

            for (int j = 1; j < n; ++j) {
                while ((double) arr[i + 1] / arr[j] < mid) {
                    ++i;
                    if (arr[i] * y > arr[j] * x) {
                        x = arr[i];
                        y = arr[j];
                    }
                }
                count += i + 1;
            }

            if (count == k) {
                return new int[]{x, y};
            }
            if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }


}