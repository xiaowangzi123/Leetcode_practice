package com.leetcode.dfs;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :图像渲染
 */
public class Solution0733 {
    public static void main(String[] args) {
        Solution0733 obj = new Solution0733();
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int sr = 1, sc = 1, newColor = 2;
        int[][] image ={{0,0,0},{0,1,1}};
        int sr = 1, sc = 1, newColor = 1;

        System.out.println(Arrays.deepToString(obj.floodFill(image, sr, sc, newColor)));

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //初始像素值
        int currColor = image[sr][sc];
        //初始像素值与新颜色相同，直接返回
        if (currColor!=newColor){
            dfs(image, sr, sc, currColor, newColor);
        }

        return image;
    }

    public void dfs(int[][] image, int x, int y, int color, int newColor) {
        //上下左右四个方向
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, color, newColor);
                }
            }
        }
    }


}