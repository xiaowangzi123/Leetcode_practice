package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/22
 * @description : 矩阵中战斗力最弱的 K 行
 */
public class Solution1337 {
    public static void main(String[] args) {
        Solution1337 obj = new Solution1337();
        int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};

        System.out.println(Arrays.toString(obj.kWeakestRows(mat, 3)));
    }

    /**
     * info数组m行两列
     * 第一列保存行下标index
     * 第二列保存1的个数count
     *
     * count数量小，战斗力弱
     * count大小一样，index小，战斗力弱
     * 输出最弱的k行的索引index
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] info = new int[m][2];
        for (int i = 0; i < m; i++) {
            info[i][0] = i;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                info[i][1]++;
            }
        }

        Arrays.sort(info, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = info[i][0];
        }
        return ans;
    }
}