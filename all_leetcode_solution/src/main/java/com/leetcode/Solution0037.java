package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/26
 * @description : 解数独
 */
public class Solution0037 {
    public static void main(String[] args) {
        Solution0037 obj = new Solution0037();
        char[][] arr = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] arr2 = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '.', '.', '8', '.', '.', '7', '9'}};
        obj.solveSudoku(arr2);
        System.out.println(Arrays.deepToString(arr2));
    }

    /**
     * 数独
     */
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        //对整个数独数组进行遍历
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    //如果该位置是一个空白格，那么我们将其加入一个用来存储空白格位置的列表中
                    spaces.add(new int[]{i, j});
                } else {
                    //如果该位置是一个数字，那么我们需要将line[i][x−1]，column[j][x−1]以及 block[⌊i/3⌋][⌊j/3⌋][x−1]均置为True。
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            //line[i][x−1]，column[j][x−1]以及 block[⌊i/3⌋][⌊j/3⌋][x−1]三者都为false，填入数字，同时把三者置为true
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                board[i][j] = (char) (digit + '0' + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;

                //下一个空白格位置进行递归。在回溯到当前递归层时，我们还要将上述的三个值重新置为false。
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}