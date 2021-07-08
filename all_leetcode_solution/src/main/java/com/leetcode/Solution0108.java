package com.leetcode;

import com.leetcode.bean.TreeNode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/8
 * @description：
 */
public class Solution0108 {
    public static void main(String[] args) {
        Solution0108 obj = new Solution0108();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = obj.sortedArrayToBST(nums);
        System.out.println(treeNode.toString());
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}

