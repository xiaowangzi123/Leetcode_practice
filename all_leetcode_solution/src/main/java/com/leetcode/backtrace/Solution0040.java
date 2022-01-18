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
//        System.out.println(obj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(obj.combinationSum2(new int[]{10, 1, 7, 1}, 8));
    }

    //ArrayDeque没有ArrayList速度快
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

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
     * 每个元素都只能用一次，{7,1}{1,7}就算是用不同下标的1，也算是同一序列
     */
    public void backtrack(int start, int n, int target, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }


        for (int i = start; i < n; i++) {
            // 剪枝，如果target - candidates[i] < 0，那target减去第i+1，i+2时,也都会小于0
            if (target - candidates[i] < 0) {
                break;
            }
            //去除重复
            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            //元素只能用一次，下次添加元素，还是要从下一元素开始，所以回溯方法中i加1
            backtrack(i + 1, n, target - candidates[i], candidates);
            path.remove(path.size() - 1);
        }

    }
}