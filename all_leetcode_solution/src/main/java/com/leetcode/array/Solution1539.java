package com.leetcode.array;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1539 {

    public static void main(String[] args) {
        Solution1539 obj = new Solution1539();
        int[] arr = {2, 3, 4, 7, 11};
        System.out.println(obj.findKthPositive(arr, 5));
    }


    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - i - 1 >= k) {
                return k + i;
            }
        }
        return k + arr.length;
    }
}

