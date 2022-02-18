package com.leetcode;


import java.beans.beancontext.BeanContext;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :找出星型图的中心节点
 */
public class Solution1791 {
    public static void main(String[] args) {
        Solution1791 obj = new Solution1791();
        System.out.println(obj.findCenter(new int[][]{{1, 2}, {1, 3}}));


        //每行元素的其中之一肯定是中心节点
        int[][] arr = new int[][]{{1, 2}, {1, 3}};
        System.out.println(arr[0][0] == arr[1][0] || arr[0][0] == arr[1][1] ? arr[0][0] : arr[0][1]);
    }

    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] cnt = new int[n + 1];
        for (int[] edge : edges) {
            cnt[edge[0]]++;
            cnt[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == n - 1) {
                return i;
            }
        }
        return 0;
    }


}