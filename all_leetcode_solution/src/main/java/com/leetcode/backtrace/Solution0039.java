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

    //ArrayDeque没有ArrayList速度快
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        if (n == 0) {
            return ans;
        }

        Arrays.sort(candidates);
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
            //加入这个剪枝条件，要求数组有序
            if (target - candidates[i] < 0) {
                break;
            }
            path.offer(candidates[i]);
            backtrack(i, n, target - candidates[i], candidates);
            path.removeLast();
        }

    }
}