package com.leetcode.tree;

import com.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/2
 * @description :二叉树的中序遍历
 *
 */
public class Solution0094 {
    public static void main(String[] args) {
        Solution0094 obj = new Solution0094();


    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    /**
     * 回溯
     */
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}