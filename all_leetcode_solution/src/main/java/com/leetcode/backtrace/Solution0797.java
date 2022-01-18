package com.leetcode.backtrace;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/18
 * @description: 所有可能的路径
 */
public class Solution0797 {
    public static void main(String[] args) {
        Solution0797 obj = new Solution0797();
        System.out.println(obj.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list.add(0);
        backtrack(0, graph.length - 1, graph);
        return ans;

    }

    private void backtrack(int i, int n, int[][] graph) {
        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int g : graph[i]) {
            list.add(g);
            backtrack(g, n, graph);
            list.remove(list.size() - 1);
        }
    }


}