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
    }

    /**
     * 战舰一排或者一列组成战舰群
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


}