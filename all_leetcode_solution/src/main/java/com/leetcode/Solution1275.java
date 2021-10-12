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

        System.out.println(0^1);
        System.out.println(1^1);
        System.out.println(0^0);
    }

    /**
     * 1. 题目分析
     * 井字棋总共只有9个格子，且赢面是固定的
     * 可以使用一个9位二进制数代表行走的结果，规定：
     * 井字棋坐标[i,j]对应于数字的第3i+j位
     * a(00),a(01),a(02),a(10),a(11),a(12),a(20),a(21),a(22)
     *   0     1    2    3     4      5     6     7      8
     * 每走一步棋等价于与对应的位进行(异)或运算
     * 判断游戏结果的方法：
     * 将一方的数字num与赢面对应的数字k进行与运算，若结果为k，此方获胜
     * 若双方都未获胜：
     * 若总步数为9步，则平局(Draw)
     * 否则，未完成(Pending)
     * 赢面数字：
     * 井字棋的赢面只有8种(3种横+3种竖+2种对角)
     * 计算举例：{[0,0],[0,1],[0,2]}为横的一种赢面，对应的99位二进制数为111000000，即十进制下的7*8*8
     * 事实上，由对应规则可以得知：
     * 3种横的赢面数字是公比为8的等比数列
     * 3种竖的赢面数字是公比为2的等比数列
     * 所有赢面数字分别为7, 56(即7*8), 448(即7*8^2), 73, 146(即73*2), 292(即73*2^2), 273, 84
     *
     */
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