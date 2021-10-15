package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/15
 * @description :岛屿的周长
 */
public class Solution0463 {
    public static void main(String[] args) {
        Solution0463 obj = new Solution0463();
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(obj.islandPerimeter(grid));

    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //等于1，值加上4；上面或前面值为1时，需要减去2
                if (grid[i][j] == 1) {
                    count += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        count -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        count -= 2;
                    }
                }
            }
        }
        return count;
    }
}