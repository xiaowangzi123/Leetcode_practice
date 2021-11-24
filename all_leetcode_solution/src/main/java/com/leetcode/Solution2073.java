package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 买票需要的时间
 */
public class Solution2073 {
    public static void main(String[] args) {
        Solution2073 obj = new Solution2073();
//        System.out.println(obj.timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(obj.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0, n = tickets.length, index = 0;
        while (tickets[k] > 0) {
            if (tickets[(index++) % n] > 0) {
                tickets[(index++) % n]--;
                ans++;
            }
        }
        return ans;
    }
}