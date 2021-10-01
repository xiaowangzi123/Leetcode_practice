package com.leetcode.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description ：子集 回溯的应用
 */
public class Solution0078 {
    public static void main(String[] args) {
        Solution0078 obj = new Solution0078();
        int[] arr = {1, 2, 3};
        System.out.println(obj.subsets(arr));

        int[] arr2 = {1, 2, 3};
        System.out.println(obj.subsets2(arr2));

        int[] arr3 = {1, 2};
        System.out.println(obj.subsets3(arr3));
        System.out.println(1 << 3);
        System.out.println(0 & (1 << 0));
        System.out.println(0 & (1 << 1));
        System.out.println(0 & (1 << 2));
    }

    /**
     * 0/1序列，n个元素共有2的n次方个子序列，如下所示
     * {1,2,3}
     * {}：000
     * {1}：100
     * {2}：010
     * {3}：001
     * {1,2}：110
     * {1,3}：101
     * {2,3}: 011
     * {1,2,3}:111
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            temp.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }

    /**
     * 前n个元素的子集f(n)，等于前n-1个元素的子集f(n-1)+{f(n-1)+an}
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //先把空子集加入
        ans.add(temp);

        //循环加入每一个元素
        for (int num : nums) {
            int t = ans.size();
            for (int j = 0; j < t; j++) {
                List<Integer> sub = new ArrayList<>(ans.get(j));
                sub.add(num);
                ans.add(sub);
            }
        }
        return ans;
    }

    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, nums, ans);
        return ans;

    }

    public void dfs(int cur, int[] nums, List<List<Integer>> ans) {
        List<Integer> temp = new ArrayList<>();
        if (cur == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[cur]);
        dfs(cur + 1, nums, ans);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, nums, ans);
    }

}