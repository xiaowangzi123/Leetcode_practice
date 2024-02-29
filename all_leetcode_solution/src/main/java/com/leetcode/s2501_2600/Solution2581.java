package com.leetcode.s2501_2600;

import java.util.*;

/**
 * 统计可能的树根数目
 * TODO
 */
public class Solution2581 {
    public static void main(String[] args) {
        Solution2581 solution = new Solution2581();
        int[][] edges = new int[][]{{0,1},{1,2},{1,3},{4,2}};
        int[][] guesses = new int[][]{{1,3},{0,1},{1,0},{2,4}};
        int[] nums2 = new int[]{3,2,3,4,2};
        System.out.println(solution.rootCount(edges,guesses,3));
    }

    private List<Integer>[] g;
    private Set<Long> s = new HashSet<>();
    private int k, ans, cnt0;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        g = new ArrayList[edges.length + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
        }

        for (int[] e : guesses) { // guesses 转成哈希表
            s.add((long) e[0] << 32 | e[1]); // 两个 4 字节 int 压缩成一个 8 字节 long
        }

        dfs(0, -1);
        reroot(0, -1, cnt0);
        return ans;
    }

    private void dfs(int x, int fa) {
        for (int y : g[x]) {
            if (y != fa) {
                if (s.contains((long) x << 32 | y)) { // 以 0 为根时，猜对了
                    cnt0++;
                }
                dfs(y, x);
            }
        }
    }

    private void reroot(int x, int fa, int cnt) {
        if (cnt >= k) { // 此时 cnt 就是以 x 为根时的猜对次数
            ans++;
        }
        for (int y : g[x]) {
            if (y != fa) {
                int c = cnt;
                if (s.contains((long) x << 32 | y)) c--; // 原来是对的，现在错了
                if (s.contains((long) y << 32 | x)) c++; // 原来是错的，现在对了
                reroot(y, x, c);
            }
        }
    }

}
