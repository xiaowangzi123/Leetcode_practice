package com.leetcode.backtrace;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/18
 * @description: 组合
 */
public class Solution0077 {
    public static void main(String[] args) {
        Solution0077 obj = new Solution0077();
        System.out.println(obj.combine(4, 2));
        System.out.println(obj.combine2(4, 2));
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return ans;
    }

    /**
     *
     */
    public void backtrack(int start, int n, int k) {
        if (k < 0) {
            return;
        }
        if (k == path.size()) {
            ans.add(new ArrayList<>(path));
        }

        //
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, n, k);
            path.remove(path.size() - 1);
        }

    }

    //一个for循环确定一个数，k个数需要k个for循环，这个方法需要再考虑一下
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i + 1; j <= n; j++) {
                temp.add(i);
                temp.add(j);
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        return ans;
    }
}