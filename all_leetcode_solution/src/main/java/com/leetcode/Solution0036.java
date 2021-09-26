package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/26
 * @description：
 */
public class Solution0036 {
    public static void main(String[] args) {
        Solution0036 obj = new Solution0036();
        String[][] arr = {{"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        System.out.println(obj.isValidSudoku(arr));
    }

    /**
     * 数独
     */
    public boolean isValidSudoku(String[][] board) {

    }
}