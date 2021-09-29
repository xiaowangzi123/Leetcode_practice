package com.leetcode.greedy;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/9/29
 * @description :
 */
public class Solution0517 {
    public static void main(String[] args) {
        Solution0517 obj = new Solution0517();
        int[] arr = {1, 0, 5};
        System.out.println(obj.findMinMoves(arr));
    }

    public int findMinMoves(int[] machines) {
        //数组总和
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        //衣服数量不能平分返回-1
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}