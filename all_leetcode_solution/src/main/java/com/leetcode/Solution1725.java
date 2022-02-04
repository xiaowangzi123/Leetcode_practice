package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/13
 * @description : 可以形成最大正方形的矩形数目
 */
public class Solution1725 {
    public static void main(String[] args) {
        Solution1725 obj = new Solution1725();
        int[][] rectangles = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        System.out.println(obj.countGoodRectangles(rectangles));
    }

    public int countGoodRectangles(int[][] rectangles) {
        int count = 0, max = Integer.MIN_VALUE;
        for (int[] arr : rectangles) {
            int temp = Math.min(arr[0], arr[1]);
            if (max == temp) {
                count++;
            } else if (max < temp) {
                max = temp;
                count = 1;
            }
        }
        return count;
    }

    public int countGoodRectangles2(int[][] rectangles) {
        int count = 0, n = rectangles.length, max = Integer.MIN_VALUE;
        int[] tans = new int[n];
        for (int i = 0; i < n; i++) {
            tans[i] = Math.min(rectangles[i][0], rectangles[i][1]);
        }

        for (int i : tans) {
            int temp = i;
            if (max == temp) {
                count++;
            } else if (max < temp) {
                max = temp;
                count = 1;
            }
        }
        return count;
    }
}