package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/12
 * @description :1275. 找出井字棋的获胜者
 */
public class Solution1275 {
    public static void main(String[] args) {
        Solution1275 obj = new Solution1275();

        int[][] moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};

        System.out.println(obj.tictactoe(moves));
    }

    public String tictactoe(int[][] moves) {
        int a = 0, b = 0, len = moves.length;
        int[] ac = {7, 56, 448, 73, 146, 292, 273, 84};
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 1) {
                b ^= 1 << (3 * moves[i][0] + moves[i][1]);
            } else {
                a ^= 1 << (3 * moves[i][0] + moves[i][1]);
            }
        }
        for (int i : ac) {
            if ((a & i) == i) {
                return "A";
            }
            if ((b & i) == i) {
                return "B";
            }
        }
        return len == 9 ? "Draw" : "Pending";

    }

    public String tictactoe2(int[][] moves) {
        int m = moves.length;
        // 用数组记录0-2行、0-2列、正对角线、副对角线是否已满3个棋子
        // count[0-2]对应0-2行、count[3-5]对应0-2列、count[6]对应正对角线、count[7]对应副对角线
        int[] count = new int[8];
        // 思路第2步已解释为何只需考虑最后一个落棋的人
        // 倒序统计此人走棋情况
        for (int i = m - 1; i >= 0; i -= 2) {
            // 此棋对行的影响
            count[moves[i][0]]++;
            // 此棋对列的影响
            count[moves[i][1] + 3]++;
            // 此棋对正对角线的影响
            if (moves[i][0] == moves[i][1]) {
                count[6]++;
            }
            // 此棋对副对角线的影响 (
            // 此处为3x3的情况，其余大小的棋盘可以类推
            if (moves[i][0] + moves[i][1] == 2) {
                count[7]++;
            }
            // 满3个棋子则胜利
            if (count[moves[i][0]] == 3 || count[moves[i][1] + 3] == 3 ||
                    count[6] == 3 || count[7] == 3)
            // A先B后 则总长度为偶时 最后为B 反之为A
            {
                return m % 2 == 0 ? "B" : "A";
            }
        }
        // 未胜时，棋盘未下满则继续
        if (moves.length < 9) {
            return "Pending";
        }
        // 未胜时，棋盘下满则平局结束
        return "Draw";
    }
}