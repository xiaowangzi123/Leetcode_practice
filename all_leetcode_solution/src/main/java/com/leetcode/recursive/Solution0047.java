package com.leetcode.recursive;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/27
 * @description ：全排列 II
 */
public class Solution0047 {
    public static void main(String[] args) {
        Solution0047 obj = new Solution0047();
        int[] arr = {1, 1, 2};
        System.out.println(obj.permuteUnique(arr));
        System.out.println(obj.permuteUnique2(arr));
        System.out.println(obj.permuteUnique3(arr));

        int[] arr2 = {1, 1, 2, 1};
        System.out.println(obj.permuteUnique(arr2));
        System.out.println(obj.permuteUnique2(arr2));
        System.out.println(obj.permuteUnique3(arr2));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        //标识某个数字是否被用过
        boolean[] used = new boolean[len];
        //排序，后续填入数字时跳过相同数字
        Arrays.sort(nums);
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
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, path, used, res);

            used[i] = false;
            path.removeLast();

        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        int len = nums.length;
        //标识某个数字是否被用过
        boolean[] used = new boolean[len];
        backTrack2(ans, new ArrayList<>(), nums, used);
        return new ArrayList<>(ans);
    }

    public void backTrack2(Set<List<Integer>> set, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            set.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    temp.add(nums[i]);
                    backTrack2(set, temp, nums, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }


    public List<List<Integer>> permuteUnique3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrace3(ans, new ArrayList<>(), nums, used);
        return new ArrayList<>(ans);
    }

    public void backTrace3(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                backTrace3(ans, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }



}