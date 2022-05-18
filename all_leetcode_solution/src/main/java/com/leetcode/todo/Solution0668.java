package com.leetcode.todo;

/**
 * @author :wyq
 * @date ：Created in 2022/5/18
 * @description : TODO
 * 668. 乘法表中第k小的数
 */
public class Solution0668 {
    public static void main(String[] args) {
        Solution0668 obj = new Solution0668();
        System.out.println(obj.findKthNumber(3, 3, 5));
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}