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
        List<ArrayDeque<Integer>> ans = new ArrayList<>(k);

        //标识某个数字是否被用过
        boolean[] used = new boolean[n + 1];

        Deque<Integer> deque = new ArrayDeque<>(n);
        dfs(k, n, 0, deque, used, ans);

        StringBuilder builder = new StringBuilder();
        for (int i : ans.get(k - 1)) {
            builder.append(i);
        }
//        return ans.get(k-1);
        return builder.toString();
    }

    private void dfs(int k, int n, int depth, Deque<Integer> deque, boolean[] used, List<ArrayDeque<Integer>> res) {
        if (res.size() == k) {
            return;
        }
        if (depth == n) {
            res.add(new ArrayDeque<>(deque));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                deque.addLast(i);
                used[i] = true;
                dfs(k, n, depth + 1, deque, used, res);
                used[i] = false;
                deque.removeLast();
            }
        }
    }

    public String getPermutation2(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}