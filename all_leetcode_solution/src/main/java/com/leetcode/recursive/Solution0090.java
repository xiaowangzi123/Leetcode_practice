package com.leetcode.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description ：子集2 回溯的应用
 */
public class Solution0090 {
    public static void main(String[] args) {
        Solution0090 obj = new Solution0090();
        int[] arr = {1, 2, 2};
        System.out.println(obj.subsetsWithDup(arr));

        int[] arr2 = {1, 2, 2};
        System.out.println(obj.subsetsWithDup(arr2));
        System.out.println(obj.subsetsWithDup(arr2));

        int[] arr3 = {1, 2};
        System.out.println(obj.subsetsWithDup(arr3));
        int[] arr4 = {1, 2};
        System.out.println("{4}-->" + obj.subsets4(arr4));
    }

    /**
     * 0/1序列，n个元素共有2的n次方个子序列，如下所示
     * {1,2,2}
     * {}：000
     * {1}：100
     * {2}：010
     * {1,2}：110
     * {2,2}: 011
     * {1,2,2}:111
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            temp.clear();
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    if (j > 0 && (i >> (j - 1) & 1) == 0 && nums[j] == nums[j - 1]) {
                        flag = false;
                        break;
                    }
                    temp.add(nums[j]);
                }
            }
            if (flag){
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }

    /**
     * 前n个元素的子集f(n)，等于前n-1个元素的子集f(n-1)+{f(n-1)+an}
     * {1,2,3}前两个元素的子集{}{1}{2}{1,2}
     * 加入元素3后，子集就是前两个元素子集{}{1}{2}{1,2}+{3}{1,3}{2,3}{1,2,3}
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

    /**
     * 递归加入每一个元素
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        recursion(nums, 0, res);
        return res;
    }

    public void recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> newSub = new ArrayList<>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }
        recursion(nums, i + 1, res);
    }

    /**
     * 回溯
     */
    public List<List<Integer>> subsets4(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        ans.add(sub);
        Arrays.sort(nums);
        backtrack(nums, 0, sub, ans);
        return ans;

    }

    public void backtrack(int[] nums, int start, List<Integer> sub, List<List<Integer>> res) {
        for (int j = start; j < nums.length; j++) {
            //去掉重复值
            if (j > start && nums[j] == nums[j - 1]) {
                continue;
            }
            sub.add(nums[j]);
            res.add(new ArrayList<>(sub));
            backtrack(nums, j + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }


    /**
     * DFS，前序遍历
     */
    public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        // 到了新的状态，记录新的路径，要重新拷贝一份
        subset = new ArrayList<Integer>(subset);

        // 这里
        res.add(subset);
        preOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，中序遍历
     */
    public static void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        subset = new ArrayList<Integer>(subset);

        inOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        // 这里
        res.add(subset);
        inOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，后序遍历
     */
    public static void postOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        subset = new ArrayList<>(subset);

        postOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        postOrder(nums, i + 1, subset, res);
        // 这里
        res.add(subset);
    }

    public static void newPreOrder(int[] nums, int i, LinkedList<Integer> stack, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        stack.push(nums[i]);
        // 这里
        res.add(new ArrayList<Integer>(stack));
        newPreOrder(nums, i + 1, stack, res);
        stack.pop();
        newPreOrder(nums, i + 1, stack, res);
    }


}