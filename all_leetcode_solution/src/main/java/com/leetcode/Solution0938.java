package com.leetcode;


import com.leetcode.bean.TreeNode;
import com.leetcode.tools.TreeNodeTools;

public class Solution0938 {

    public static void main(String[] args) {
        Solution0938 obj = new Solution0938();
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        System.out.println(TreeNodeTools.preorderTraversal(node));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (low < root.val) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }

        return sum;
    }


}

