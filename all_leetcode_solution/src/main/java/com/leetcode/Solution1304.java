package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/22
 * @description : 和为零的N个唯一整数
 */
public class Solution1304 {
    public static void main(String[] args) {
        Solution1304 obj = new Solution1304();
        System.out.println(Arrays.toString(obj.sumZero(2)));
        System.out.println(Arrays.toString(obj.sumZero2(2)));

        System.out.println(Arrays.toString(obj.sumZero(5)));
        System.out.println(Arrays.toString(obj.sumZero2(5)));
    }

    //n为2时有误
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            ans[i] = i;
            sum += i;
        }
        ans[n - 1] = -sum;
        return ans;
    }

    public int[] sumZero2(int n) {
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            ans[i] = i;
            sum += i;
        }
        ans[0] = -sum;
        return ans;
    }
}