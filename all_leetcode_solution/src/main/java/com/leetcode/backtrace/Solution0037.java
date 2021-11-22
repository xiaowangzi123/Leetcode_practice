package com.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
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
                {'5', '3', '.', '6', '7', '.', '.', '1', '.'},
                {'6', '.', '2', '1', '9', '5', '.', '.', '8'},
                {'.', '9', '8', '.', '.', '.', '5', '6', '.'},
                {'8', '.', '.', '7', '6', '1', '4', '.', '3'},
                {'4', '2', '.', '8', '.', '3', '.', '9', '1'},
                {'7', '.', '3', '.', '2', '.', '8', '.', '6'},
                {'.', '6', '1', '5', '3', '7', '2', '8', '.'},
                {'2', '.', '7', '4', '1', '9', '6', '3', '5'},
                {'.', '4', '.', '.', '8', '.', '.', '7', '9'}};
        obj.solveSudoku22(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    /**
     * 解数独
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
                    //如果该位置是‘.’(即没有数字)，那么将其加入一个用来存储空白格位置的列表中
                    spaces.add(new int[]{i, j});
                } else {
                    //如果该位置是一个数字，将line[i][x−1]，column[j][x−1]以及 block[i/3][j/3][x−1]均置为True。
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
        //
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            //line[i][x−1]，column[j][x−1]以及 block[i/3][j/3][x−1]三者都为false时，填入数字，同时把三者置为true
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                board[i][j] = (char) (digit + '0' + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;

                //下一个空白格位置进行递归。在回溯到当前递归层时，还要将上述的三个值重新置为false。
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }

    /**
     * 数独首先行，列，还有 3*3 的方格内数字是 1~9 不能重复。
     * 声明布尔数组，表明行列中某个数字是否被使用了， 被用过为 true，没用过为 false。
     * 初始化布尔数组，表明哪些数字已经被使用过了。
     * 尝试去填充数组，只要行，列， 还有 3*3 的方格内出现已经被使用过的数字，我们就不填充，否则尝试填充。
     * 如果填充失败，那么我们需要回溯。将原来尝试填充的地方改回来。
     * 递归直到数独被填充完成。
     */
    public void solveSudoku2(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1', k = (i / 3) * 3 + j / 3;
                    row[i][num] = col[j][num] = box[k][num] = true;
                }
            }
        }
        backTrack2(board, 0, row, col, box);
    }

    public boolean backTrack2(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (n == 81) {
            return true;
        }
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') {
            return backTrack2(board, n + 1, row, col, box);
        }

        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[k][num]) {
                continue;
            }
            board[i][j] = (char) (num + '1');
            row[i][num] = col[j][num] = box[k][num] = true;
            if (backTrack2(board, n + 1, row, col, box)) {
                return true;
            }
            row[i][num] = col[j][num] = box[k][num] = false;
        }
        board[i][j] = '.';
        return false;
    }

    boolean end = false;
    int point = 0;

    public void solveSudoku22(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1', k = (i / 3) * 3 + j / 3;
                    row[i][num] = col[j][num] = box[k][num] = true;
                } else {
                    list.add(new int[]{i, j});
                }
            }
        }
        backTrack22(list, board, 0, row, col, box);
    }


    public void backTrack22(List<int[]> list, char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (n == list.size()) {
            end = true;
            return;
        }
        int i = list.get(n)[0], j = list.get(n)[1];
        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9 && !end; num++) {
            if (!row[i][num] && !col[j][num] && !box[k][num]) {
                board[i][j] = (char) (num + '1');
                row[i][num] = col[j][num] = box[k][num] = true;
                backTrack22(list, board, n + 1, row, col, box);
                row[i][num] = col[j][num] = box[k][num] = false;
            }
        }


    }
}