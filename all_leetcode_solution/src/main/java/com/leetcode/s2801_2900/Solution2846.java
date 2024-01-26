package com.leetcode.s2801_2900;

import java.util.*;

/**
 * 边权重均等查询
 * https://blog.csdn.net/qq_42958831/article/details/132664762
 */
public class Solution2846 {
    public static void main(String[] args) {

    }

    /**
     * TODO
     * 关键：提炼问题中需要的信息
     * 【保留出现次数最多的边，其余的边全部修改】
     * 1. 从 a 到 b 的路径长度（边数）
     * = depth[a] - depth[lca] + (depth[b] - depth[lca]) (lca 为 a 和 b 的最近公共祖先)
     * ==> 从 a 到 b 的边数为 depth[a] + depth[b] - 2 * depth[lca]
     * 2. 从 a 到 b 出现次数最多的边
     * 1 <= wi <= 26
     * ==> 统计从节点 x 到 x的第 2^i 个祖先节点这条路径上 每种边权的出现次数
     */
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        List<int[]>[] g = new ArrayList[n]; // x, y, weight
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1], w = e[2] - 1;
            g[x].add(new int[]{y, w});
            g[y].add(new int[]{x, w});
        }

        int m = 32 - Integer.numberOfLeadingZeros(n); // n 的二进制长度
        int[][] pa = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(pa[i], -1);
        }

        // cnt:从节点 x 到 x的第 2^i 个祖先节点这条路径上 每种边权的出现次数
        int[][][] cnt = new int[n][m][26];
        int[] depth = new int[n];
        // 一次dfs处理出 从【节点x 到 x父节点】 的 【边数 + 各边权出现次数 + 深度】
        dfs(0, -1, g, pa, cnt, depth);

        // 倍增求 【从节点x到 x^i个祖先节点】 的 各边权出现次数
        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i]; // p:x 的祖先节点
                if (p != -1) {
                    int pp = pa[p][i]; // pp : x祖先的祖先节点
                    pa[x][i + 1] = pp;
                    for (int j = 0; j < 26; j++) {
                        cnt[x][i + 1][j] = cnt[x][i][j] + cnt[p][i][j];
                    }
                }
            }
        }

        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int x = queries[qi][0], y = queries[qi][1];

            int pathLen = depth[x] + depth[y];
            int[] cw = new int[26];
            if (depth[x] > depth[y]) { // 目的是让x的深度小于y的深度
                int tmp = x;
                x = y;
                y = tmp;
            }

            // 让 y 和 x 在同一深度
            for (int k = depth[y] - depth[x]; k > 0; k &= k - 1) {
                int i = Integer.numberOfTrailingZeros(k);
                int p = pa[y][i];
                for (int j = 0; j < 26; j++) {
                    cw[j] += cnt[y][i][j];
                }
                y = p;
            }

            // 求 x 和 y 上的lca节点
            if (y != x) { // 从大到小尝试跳（lca模板）
                for (int i = m - 1; i >= 0; i--) {
                    int px = pa[x][i], py = pa[y][i];
                    if (px != py) { // 说明 lca节点在pa节点上面，更新x和y
                        for (int j = 0; j < 26; j++) {
                            cw[j] += cnt[x][i][j] + cnt[y][i][j];
                        }
                        x = px;
                        y = py; // x 和 y 同时上跳 2^i 步
                    }
                }
                for (int j = 0; j < 26; j++) {
                    cw[j] += cnt[x][0][j] + cnt[y][0][j];
                }
                x = pa[x][0]; // 循环结束，x和lca节点只有一步之遥，即lca节点是x的父节点
            }

            int lca = x;
            pathLen -= depth[lca] * 2;
            int maxcw = 0; // 边权最大出现次数
            for (int i = 0; i < 26; i++) {
                maxcw = Math.max(maxcw, cw[i]);
            }
            ans[qi] = pathLen - maxcw;
        }
        return ans;
    }

    public void dfs(int x, int fa, List<int[]>[] g, int[][] pa, int[][][] cnt, int[] depth) {
        pa[x][0] = fa;
        for (int[] e : g[x]) {
            int y = e[0], w = e[1];
            if (y != fa) {
                cnt[y][0][w] = 1; // 表示 从 y 到 y的第2^0节点(x节点) 有一个边权为w的边
                depth[y] = depth[x] + 1;
                dfs(y, x, g, pa, cnt, depth);
            }
        }
    }
}
