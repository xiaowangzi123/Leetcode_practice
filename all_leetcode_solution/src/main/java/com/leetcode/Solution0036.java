package com.leetcode;

import java.util.HashSet;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/26
 * @description : 有效的数独
 */
public class Solution0036 {
    public static void main(String[] args) {
        Solution0036 obj = new Solution0036();
        char[][] arr = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(obj.isValidSudoku(arr));
        System.out.println(obj.isValidSudoku2(arr));
    }

    /**
     * 数独
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subBox = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int index = ch - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subBox[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subBox[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }
                if (board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] != '.' && !cube.add(board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}