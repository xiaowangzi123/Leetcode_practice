package com.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/27
 * @description :全排列
 */
class Solution0046 {
    public static void main(String[] args) {
        Solution0046 obj = new Solution0046();
        int[] arr = {1, 2, 3};
        System.out.println(obj.permute(arr));
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
        int len = nums.length;
        //标识某个数字是否被用过
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }


}