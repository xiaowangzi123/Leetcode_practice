package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/1/15
 * @description: 计算力扣银行的钱
 */
public class Solution1716 {
    public static void main(String[] args) {
        Solution1716 obj = new Solution1716();
        System.out.println(obj.totalMoney2(4));
        System.out.println(obj.totalMoney2(10));
        System.out.println(obj.totalMoney2(20));
    }

    public int totalMoney(int n) {
        int ans = 0, k = n % 7, m = n / 7;
        for (int i = 1; i <= k; i++) {
            ans += (i + m);
        }
        ans += (28 * m);
        if ((m - 1) > 0) {
            ans += (m - 1) * m * 7 / 2;
        }
        return ans;
    }

    public int totalMoney2(int n) {
        int ans = 0, week = 0;
        int day = 1;
        for (int i = 1; i <= n; i++) {
            ans += day + week;
            day++;
            if (day == 8) {
                day = 1;
                week++;
            }
        }
        return ans;
    }


}