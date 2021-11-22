package com.leetcode.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description ：子集2 回溯的应用
 * {@link Solution0078}
 */
public class Solution0090 {
    public static void main(String[] args) {
        Solution0090 obj = new Solution0090();
        System.out.println(obj.subsetsWithDup(new int[]{2, 2, 2}));
        System.out.println(obj.subsetsWithDup2(new int[]{2, 2, 2}));
        System.out.println(obj.subsetsWithDup3(new int[]{2, 2, 2}));
        System.out.println(obj.subsetsWithDup33(new int[]{2, 2, 2}));

        System.out.println("--------------------");
        System.out.println(obj.subsetsWithDup(new int[]{1, 2, 2, 2}));
        System.out.println(obj.subsetsWithDup2(new int[]{1, 2, 2, 2}));
        System.out.println(obj.subsetsWithDup3(new int[]{1, 2, 2, 2}));
        System.out.println(obj.subsetsWithDup33(new int[]{1, 2, 2, 2}));

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
        //排序，方便后续去除重复值
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            temp.clear();
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                //i & (1 << j))不为0，表明此处有值
                if ((i & (1 << j)) != 0) {
                    //nums[j]与nums[j-1]相等，且nums[j-1]没有加入子集中时，此时加入nums[j]会重复，需跳出循环
                    if (j > 0 && (i >> (j - 1) & 1) == 0 && nums[j] == nums[j - 1]) {
                        flag = false;
                        break;
                    }
                    temp.add(nums[j]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }

    /**
     * 需要改进
     * 此方法在多个连续数相同时，无法判断相同值的具体某一个是否加入子集
     */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //先把空子集加入
        ans.add(temp);

        Arrays.sort(nums);
        //循环加入每一个元素
        for (int num : nums) {
            int t = ans.size();
            for (int j = 0; j < t; j++) {
                List<Integer> sub = new ArrayList<>(ans.get(j));
                //此处需要修改
                if (j > 1 && sub.contains(nums[j - 1]) && nums[j] == nums[j - 1]) {
                    break;
                }
                sub.add(num);
                ans.add(sub);
            }
        }
        return ans;
    }


    /**
     * 回溯
     */
    public List<List<Integer>> subsetsWithDup3(int[] nums) {
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

    public List<List<Integer>> subsetsWithDup33(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        backtrack33(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack33(int[] nums, int start, List<Integer> sub, List<List<Integer>> ans) {
        if (start <= nums.length) {
            ans.add(new ArrayList<>(sub));
        }
        for (int j = start; j < nums.length; j++) {
            //去掉重复值
            if (j > start && nums[j] == nums[j - 1]) {
                continue;
            }
            sub.add(nums[j]);
            backtrack33(nums, j + 1, sub, ans);
            sub.remove(sub.size() - 1);
        }
    }

}