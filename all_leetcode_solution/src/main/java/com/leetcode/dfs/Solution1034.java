package com.leetcode.dfs;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/12/7
 * @description : 边界着色
 */
public class Solution1034 {
    public static void main(String[] args) {
        Solution1034 obj = new Solution1034();
        //[[3, 3], [3, 2]]
        System.out.println(Arrays.deepToString(obj.colorBorder(new int[][]{{1, 1}, {1, 2}}, 0, 0, 3)));
        //[[1, 3, 3], [2, 3, 3]]
        System.out.println(Arrays.deepToString(obj.colorBorder(new int[][]{{1, 2, 2}, {2, 3, 2}}, 0, 1, 3)));
        //[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
        System.out.println(Arrays.deepToString(obj.colorBorder(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1, 1, 2)));
        //[[3, 1, 1], [1, 1, 1], [1, 1, 1]]
        System.out.println(Arrays.deepToString(obj.colorBorder(new int[][]{{2, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 0, 0, 3)));
        //[[1, 1, 1, 1, 1], [1, 3, 3, 3, 1], [1, 3, 1, 3, 1], [1, 3, 3, 3, 1], [1, 1, 1, 1, 1]]
        System.out.println(Arrays.deepToString(obj.colorBorder(new int[][]{{1, 1, 1, 1, 1}, {1, 2, 2, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 2, 2, 1}, {1, 1, 1, 1, 1}}, 1, 1, 3)));
    }

    /**
     * 颜色相同且位置相邻的属于同一个连通分量
     * 此格子在联通分量中且周围颜色与其不同  或者在第一行列和最后一行列的格子属于边界
     * 对边界进行着色，
     * 注意：如果grid[row][col]属于连通分量，但位置在表格四个边上，且相邻位置有颜色不和其相等，则其属于边界
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        //记录当前格子是否被访问过
        boolean[][] flags = new boolean[m][n];
        //记录边界的下标{i,j}
        List<int[]> borders = new ArrayList<>();
        int orgColor = grid[row][col];

        dfs(orgColor, row, col, flags, grid, borders);
        //对边界值着色
        for (int[] a : borders) {
            grid[a[0]][a[1]] = color;
        }
        return grid;
    }

    private void dfs(int orgColor, int x, int y, boolean[][] flags, int[][] grid, List<int[]> borders) {
        int m = grid.length, n = grid[0].length;
        boolean isBorder = false;
        //定义四个方向
        int[][] d = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for (int i = 0; i < 4; i++) {
            int x1 = d[i][0] + x, y1 = d[i][1] + y;
            //遍历四个方向，超出边界或者与g(x,y)相邻的格子的颜色与g(x,y)不同，则g(x,y)为边界
            if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == orgColor) {
                if (!flags[x1][y1]) {
                    flags[x1][y1] = true;
                    dfs(orgColor, x1, y1, flags, grid, borders);
                }
            } else {
                isBorder = true;
            }
        }
        if (isBorder) {
            borders.add(new int[]{x, y});
        }
    }
}