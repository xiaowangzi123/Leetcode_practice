package com.leetcode.recursive;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/27
 * @description :全排列，元素不重复
 */
class Solution0046 {
    public static void main(String[] args) {
        Solution0046 obj = new Solution0046();
        int[] arr = {1, 2, 3};
        System.out.println(obj.permute(arr));
        System.out.println(obj.permute3(arr));

        int[] arr2 = {1, 1, 3};
        System.out.println(obj.permute2(arr2));

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //数组转list，ArrayUtils.toObject()需要引入common-long3包
//        List<Integer> output = Arrays.asList(ArrayUtils.toObject(nums));
        List<Integer> output = Arrays.stream(nums).boxed().collect(Collectors.toList());
        /*List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }*/

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int index) {
        // 所有数都填完了
        if (index == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = index; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, index, i);
            // 继续递归填下一个数
            backtrack(n, output, res, index + 1);
            // 撤销操作
            Collections.swap(output, index, i);
        }
    }


    public List<List<Integer>> permute2(int[] nums) {
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        //标识某个数字是否被用过
        boolean[] used = new boolean[n];
        Deque<Integer> path = new ArrayDeque<>(n);
        dfs(nums, n, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int length, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, length, depth + 1, path, used, res);
                used[i] = false;
                path.removeLast();
            }
        }
    }


    public List<List<Integer>> permute3(int[] nums) {
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> ans = new ArrayList<>();
        backTrack3(ans, new ArrayList<>(), nums);
        return ans;
    }

    public void backTrack3(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!temp.contains(nums[i])) {
                    temp.add(nums[i]);
                    backTrack3(list, temp, nums);
                    temp.remove(nums[i]);
                }
            }
        }
    }

}