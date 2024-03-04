package com.leetcode.s1601_1700;

/**
 * 最富有客户的资产总量
 */
public class Solution1672 {
    public static void main(String[] args) {
        Solution1672 obj = new Solution1672();
        int[][] arr = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(obj.maximumWealth(arr));
    }

    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int sum = 0;
            //每一行都可以看作是一个人的资产
            for (int j = 0; j < accounts[0].length; j++) {
                sum += account[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}