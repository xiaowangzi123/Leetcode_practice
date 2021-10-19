package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/20
 * @description : 高度检查器
 */
public class Solution1051 {
    public static void main(String[] args) {
        Solution1051 obj = new Solution1051();
        int[] arr = {1, 1, 4, 2, 1, 3};
    }

    //题目简单来说就是找排序后，位置值不一样的数量
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] temp = heights.clone();
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != temp[i]) {
                count++;
            }
        }
        return count;
    }
}