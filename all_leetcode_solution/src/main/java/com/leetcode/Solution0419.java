package com.leetcode;

/**
 * @author: wyq
 * @create time: 2021/12/18
 * @description: 甲板上的战舰
 */
public class Solution0419 {
    public static void main(String[] args) {
        Solution0419 obj = new Solution0419();
        System.out.println(obj.countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}}));
        System.out.println(obj.countBattleships2(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}}));
    }

    /**
     * 战舰一排或者一列组成战舰群
     * 确定第一个X位置的坐标，从此坐标向右或向下遍历，如果值为X，重新赋值为其他
     */
    public int countBattleships(char[][] board) {
        int ans = 0, m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    for (int k = i + 1; k < m && board[k][j] == 'X'; k++) {
                        board[k][j] = '.';
                    }
                    for (int k = j + 1; k < n && board[i][k] == 'X'; k++) {
                        board[i][k] = '.';
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 遍历二维数组，找到值为X的坐标(i,j)
     * 判断(i-1,j)和(i,j-1)的值是否为X，如果是，则(i,j)属于上一个战舰群；否，则（i,j）是新的战舰群的开始
     */
    public int countBattleships2(char[][] board) {
        int ans = 0, m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

}