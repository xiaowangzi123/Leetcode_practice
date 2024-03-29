package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/19
 * @description : 可以被一步捕获的棋子数
 */
public class Solution0999 {
    public static void main(String[] args) {
        Solution0999 obj = new Solution0999();
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(obj.numRookCaptures(board));

    }

    public int numRookCaptures(char[][] board) {
        //找到车R的位置(x,y)
        int x = -1, y = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        int count = 0;
        //四个方向
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {1, -1, 0, 0};
        //最多走7步，要不碰到象或者卒或者到达边界
        for (int i = 0; i < 4; i++) {
            int step = 1;
            while (step < 8) {
                int a = x + step * dirX[i];
                int b = y + step * dirY[i];
                if (a < 0 || a >= 8 || b < 0 || b >= 8 || board[a][b] == 'B') {
                    break;
                }
                if (board[a][b] == 'p') {
                    count++;
                    break;
                }
                step++;
            }
        }

        return count;
    }
}