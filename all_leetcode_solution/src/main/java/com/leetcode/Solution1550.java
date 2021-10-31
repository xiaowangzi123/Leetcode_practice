package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/31
 * @description : 存在连续三个奇数的数组
 */
public class Solution1550 {
    public static void main(String[] args) {
        Solution1550 obj = new Solution1550();
//        int[] arr = {2, 6, 4, 1};
        int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(obj.threeConsecutiveOdds(arr));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }
        return false;
    }
}