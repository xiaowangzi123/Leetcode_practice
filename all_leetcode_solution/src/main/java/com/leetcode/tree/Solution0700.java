package com.leetcode.tree;

import com.leetcode.bean.TreeNode;


/**
 * @author: wyq
 * @create time: 2021/11/26
 * @description: 二叉搜索树中的搜索
 */
public class Solution0700 {
    public static void main(String[] args) {
        Solution0700 obj = new Solution0700();
        TreeNode t4 = new TreeNode(1, null, null);
        TreeNode t5 = new TreeNode(3, null, null);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(7, null, null);
        TreeNode t1 = new TreeNode(4, t2, t3);

        System.out.println(obj.searchBST(t1, 2));


    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return searchBST(root.val > val ? root.left : root.right, val);
    }

}