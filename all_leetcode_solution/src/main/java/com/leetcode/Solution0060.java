package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/9/29
 * @description :
 */
public class Solution0060 {
    public static void main(String[] args) {
        Solution0060 obj = new Solution0060();
        System.out.println(obj.getPermutation(3, 3));
        System.out.println(obj.getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>(k);
        List<Integer> output = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            output.add(i);
        }

        //标识某个数字是否被用过
        boolean[] used = new boolean[n + 1];

        Deque<Integer> path = new ArrayDeque<>(n);
        dfs(k, n, 0, path, used, ans);

        StringBuilder builder = new StringBuilder();
        for (int i : ans.get(k - 1)) {
            builder.append(i);
        }
        return builder.toString();
    }

    private void dfs(int k, int n, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (res.size() == k) {
            return;
        }
        if (depth == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                path.addLast(i);
                used[i] = true;
                dfs(k, n, depth + 1, path, used, res);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}