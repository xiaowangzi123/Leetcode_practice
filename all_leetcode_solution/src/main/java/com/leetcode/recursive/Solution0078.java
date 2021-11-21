package com.leetcode.recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description ：子集 回溯的应用
 */
public class Solution0078 {
    public static void main(String[] args) {
        Solution0078 obj = new Solution0078();
        System.out.println(obj.subsets(new int[]{1, 2, 3}));
        System.out.println(obj.subsets2(new int[]{1, 2, 3}));
        System.out.println(obj.subsets3(new int[]{1, 2, 3}));
        System.out.println("----------------------------");
        System.out.println(obj.subsets3(new int[]{1, 2}));
        System.out.println(obj.subsets4(new int[]{1, 2, 3}));
        System.out.println(obj.subsets44(new int[]{1, 2, 3}));


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
                //&运算结果不等于0，表明此处有值
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
     * {}
     * {}{1}
     * {}{1}{2}{1,2}
     * {}{1}{2}{1,2}{3}{1,3}{2,3}{1,2,3}
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        recursion(nums, 0, res);
        return res;
    }

    public void recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            return;
        }
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> temp = new ArrayList<>(res.get(j));
            temp.add(nums[i]);
            res.add(temp);
        }
        recursion(nums, i + 1, res);
    }

    public List<List<Integer>> subsets33(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }
        return ans;
    }

    /**
     * 回溯
     */
    public List<List<Integer>> subsets4(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        ans.add(sub);
        backtrack(nums, 0, sub, ans);
        return ans;

    }

    public void backtrack(int[] nums, int start, List<Integer> sub, List<List<Integer>> res) {
        for (int j = start; j < nums.length; j++) {
            //去掉重复值
            /*if (j > start && nums[j] == nums[j - 1]) {
                continue;
            }*/
            sub.add(nums[j]);
            res.add(new ArrayList<>(sub));
            backtrack(nums, j + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }

    public List<List<Integer>> subsets44(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack44(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void backTrack44(int start, int[] nums, List<Integer> sub, List<List<Integer>> ans) {
        if (start <= nums.length) {
            ans.add(new ArrayList<>(sub));
        }
        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            backTrack44(i + 1, nums, sub, ans);
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