package com.leetcode.array;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution0977 {

    public static void main(String[] args) {
        Solution0977 obj = new Solution0977();
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(obj.sortedSquares(arr)));
    }


    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
//            A[i] = A[i] * A[i];
            A[i] = (int) Math.pow(A[i], 2);
        }
        Arrays.sort(A);
        return A;
    }


}