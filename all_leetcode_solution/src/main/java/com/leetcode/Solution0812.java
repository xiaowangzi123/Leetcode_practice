package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description : 最大的三角面积
 */
public class Solution0812 {
    public static void main(String[] args) {
        Solution0812 obj = new Solution0812();
        int[][] points = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(obj.largestTriangleArea(points));
    }

    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    /**
     * 高斯鞋带公式
     * A:(x1, y1) , B:(x2, y2) , C:(x3, y3)
     * S三角形=0.5∗((x1∗y2+x2∗y3+x3∗y1)−(y1∗x2+y2∗x3+y3∗x1))
     */
    public double area(int[] a, int[] b, int[] c) {
        return 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1]
                - a[1] * b[0] - b[1] * c[0] - c[1] * a[0]);
    }

}