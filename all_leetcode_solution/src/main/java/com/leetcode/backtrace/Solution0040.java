package com.leetcode.backtrace;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/18
 * @description: 组合总和 II
 */
public class Solution0040 {
    public static void main(String[] args) {
        Solution0040 obj = new Solution0040();
        System.out.println(obj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    //ArrayDeque没有ArrayList速度快
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        if (n == 0) {
            return ans;
        }

        backtrack(0, n, target, candidates);
        return ans;
    }

    /**
     * 每一个元素可以重复使用，考虑了所有的候选数，因此出现了重复的列表。
     * 从每一层的第 22 个结点开始，都不能再搜索产生同一层结点已经使用过的 candidate 里的元素
     */
    public void backtrack(int start, int n, int target, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }

        //元素可以重复，下次添加元素，还是要从当前元素开始，所以回溯方法中i没有加1
        for (int i = start; i < n; i++) {
            path.offer(candidates[i]);
            backtrack(i + 1, n, target - candidates[i], candidates);
            path.removeLast();
        }

    }
}