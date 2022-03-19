package com.leetcode.todo;

import com.leetcode.bean.TreeNode;

/**
 * @author: wyq
 * @create time: 2022/3/19
 * @description: TODO
 * 根据二叉树创建字符串
 */
public class Solution0606 {
    public static void main(String[] args) {
        Solution0606 obj = new Solution0606();

    }

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}