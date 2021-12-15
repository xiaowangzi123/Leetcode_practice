package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2021/12/15
 * @description: 喧闹和富有 todo
 */
public class Solution0851 {
    public static void main(String[] args) {
        Solution0851 obj = new Solution0851();
        int[][] richer = {{1, 0},{2, 1},{3, 1},{3, 7},{4, 3},{5, 3},{6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        System.out.println(Arrays.toString(obj.loudAndRich(richer, quiet)));
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] r : richer) {
            g[r[1]].add(r[0]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; ++i) {
            dfs(i, quiet, g, ans);
        }
        return ans;
    }

    public void dfs(int x, int[] quiet, List<Integer>[] g, int[] ans) {
        if (ans[x] != -1) {
            return;
        }
        ans[x] = x;
        for (int y : g[x]) {
            dfs(y, quiet, g, ans);
            if (quiet[ans[y]] < quiet[ans[x]]) {
                ans[x] = ans[y];
            }
        }
    }

}