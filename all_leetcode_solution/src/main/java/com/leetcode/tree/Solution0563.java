package com.leetcode.tree;

import com.leetcode.bean.TreeNode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/18
 * @description : 二叉树的坡度
 */
public class Solution0563 {
    public static void main(String[] args) {
        Solution0563 obj = new Solution0563();
    }

    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;
    }
}