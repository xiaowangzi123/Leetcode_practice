package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/9
 * @description : 重复至少K次且长度为M的模式
 */
public class Solution1566 {
    public static void main(String[] args) {
        Solution1566 obj = new Solution1566();
        int[] arr = {1, 2, 4, 4, 4, 4};
        System.out.println(obj.containsPattern(arr, 1, 3));
        System.out.println(obj.containsPattern(arr, 2, 3));
        System.out.println("--------------");

        int[] arr2 = {4, 4};
        System.out.println(obj.containsPattern2(arr2, 1, 2));
    }

    /**
     * j代表要找的序列长度
     * 如果长度j==m*k,表明找到了复合条件的子序列
     */
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i <= n - m * k; i++) {
            int j = 0;
            while (j < m * k) {
                if (arr[i + j] != arr[i + j % m]) {
                    break;
                } else {
                    j++;
                }
                if (j == m * k) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean containsPattern2(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i <= n - m * k; i++) {
            int j = 0;
            for (; j < m * k; j++) {
                if (arr[i + j] != arr[i + j % m]) {
                    break;
                }
            }
            if (j == m * k) {
                return true;
            }
        }
        return false;
    }
}