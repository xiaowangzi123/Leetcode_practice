package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :
 */
public class Solution0832 {
    public static void main(String[] args) {
        Solution0832 obj = new Solution0832();
        int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(obj.flipAndInvertImage(image)));

        //相同为0，不同为1
        System.out.println(1 ^ 1);
        System.out.println(0 ^ 1);
    }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] arr : image) {
            for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] ^= 1;
            }
        }
        return image;
    }
}