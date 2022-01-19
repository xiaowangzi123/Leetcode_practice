package com.leetcode.backtrace;

import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description ：子集 回溯的应用
 */
public class Solution0079 {
    public static void main(String[] args) {
        Solution0079 obj = new Solution0079();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(obj.exist(board, "ABCCED"));
    }


    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = backtrack(i, j, 0, word, used, board);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int i, int j, int index, String word, boolean[][] used, char[][] board) {
        if (word.charAt(index) != board[i][j]) {
            return false;
        } else if (index == word.length()) {
            return true;
        }

        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        used[i][j] = true;
        for (int[] dir : directions) {
            int x = dir[0] + i, y = dir[1] + j;
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (!used[x][y]) {
                    boolean flag = backtrack(x, y, index + 1, word, used, board);
                    if (flag) {
                        return true;
                    }
                }
            }
        }

        used[i][j] = false;
        return false;
    }

}