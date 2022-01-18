package com.leetcode.backtrace;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/18
 * @description: 组合总和
 */
public class Solution0039 {
    public static void main(String[] args) {
        Solution0039 obj = new Solution0039();
        System.out.println(obj.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        if (n == 0) {
            return ans;
        }

        backtrack(0,n,target,candidates);
        return ans;
    }

    public void backtrack(int start, int n, int target, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = 0; i < n; i++) {
            path.offer(candidates[i]);
            backtrack(i, n, target-candidates[i], candidates);
            path.removeLast();
        }

    }
}