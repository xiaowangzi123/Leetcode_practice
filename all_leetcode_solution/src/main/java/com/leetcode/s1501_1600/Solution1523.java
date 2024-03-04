package com.leetcode.s1501_1600;

/**
 * 在区间范围内统计奇数数目
 */
public class Solution1523 {
    public static void main(String[] args) {
        Solution1523 obj = new Solution1523();
        System.out.println(obj.countOdds(3, 7));
        System.out.println(obj.countOdds(8, 10));
    }

    /**
     * 1.[偶, 偶]: [2, 4] -> 答案: (4-2)/2
     * 2.[奇, 奇]: [3, 7] -> 答案: (7-3)/2+1
     * 3.[偶, 奇]: [2, 5] -> 答案: (5-2)/2+1
     * 4.[奇, 偶]: [1, 4] -> 答案: (4-1)/2+1
     */
    public int countOdds(int low, int high) {
        int count = 0;
        if (low % 2 == 0 && high % 2 == 0) {
            count = (high - low) / 2;
        } else {
            count = 1 + (high - low) / 2;
        }
        return count;
    }
}