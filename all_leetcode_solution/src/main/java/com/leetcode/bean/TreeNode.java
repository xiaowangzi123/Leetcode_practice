package com.leetcode.bean;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/20
 * @description：Definition for a binary tree node.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
