package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/21
 * @description : 玩筹码
 */
public class Solution1217 {
    public static void main(String[] args) {
        Solution1217 obj = new Solution1217();
        int[] arr = {2, 2, 2, 3, 3};
        System.out.println(obj.minCostToMoveChips(arr));
        System.out.println(obj.minCostToMoveChips2(arr));
    }

    /**
     * 数组是每个筹码在数轴上的位置
     * 偶数位移动到偶数位，代价为0
     * 奇数位移动到奇数位，代价为0,
     * 此时看奇数位多，还是偶数位多，少的向多的移动，代价最小
     */
    public int minCostToMoveChips(int[] position) {
        int a = 0, b = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                a++;
            } else {
                b++;
            }
        }
        return a > b ? b : a;
    }

    public int minCostToMoveChips2(int[] position) {
        int count = 0, n = position.length;

        for (int i : position) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count > n - count ? n - count : count;
    }
}