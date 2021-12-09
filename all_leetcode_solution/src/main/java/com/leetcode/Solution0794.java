package com.leetcode;

/**
 * @author: wyq
 * @create time: 2021/12/9
 * @description: 有效的井字游戏
 */
public class Solution0794 {
    public static void main(String[] args) {
        Solution0794 obj = new Solution0794();

        System.out.println(obj.validTicTacToe(new String[]{"O  ", "   ", "   "}));
        System.out.println(obj.validTicTacToe(new String[]{"XOX", " X ", "   "}));
        System.out.println(obj.validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        System.out.println(obj.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    }

    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;
        //统计'X'和'O'的个数
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') {
                    countX++;
                }
                if (c == 'O') {
                    countO++;
                }
            }
        }

        //X先手，个数和'O'相等或者大一
        if (countX != countO && countX != countO + 1) {
            return false;
        }

        //X赢，个数比'O'多一
        if (isWin(board, 'X') && countX != countO + 1) {
            return false;
        }

        //O赢，个数相同
        if (isWin(board, 'O') && countX != countO) {
            return false;
        }

        return true;
    }

    public boolean isWin(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            //判断是否在同一行
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
                return true;
            }
            //判断是否在同一列
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
                return true;
            }
        }
        //判断两条对角线
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
            return true;
        }
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
            return true;
        }
        return false;
    }

}